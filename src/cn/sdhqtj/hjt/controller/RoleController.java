package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.sdhqtj.hjt.entity.MenuNode;
import cn.sdhqtj.hjt.entity.Role;
import cn.sdhqtj.hjt.service.RoleService;

/**
 * 角色controller
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	@Resource
	RoleService roleservice;
	Role role;
	List<Role> rolelist;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		rolelist = roleservice.rolequery();
		model.addAttribute("rolelist", rolelist);

		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("addmsg", "角色添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "角色修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "角色删除成功");
		}
		return "role/list";
	}
	
	/**
	 * 权限菜单列表
	 */
	@RequestMapping("/menulist")
	@ResponseBody
	public String  menulist() {
		List<MenuNode> mlist =  roleservice.getmenunodes();
		String str=JSON.toJSON(mlist).toString();
		return str;
	}
	

	/**
	 * 添加角色
	 */
	@RequestMapping("/add")
	public String add() {

		return "role/add";
	}

	/**
	 * 执行添加角色
	 */
	@RequestMapping("/doadd")
	public String doadd(HttpServletRequest request, Role record, Model model) {
		rolelist = roleservice.checkrepeat(record);
		String[] mlist = request.getParameterValues("menutree");

		if (rolelist.size() > 0) {
			// 添加失败
			model.addAttribute("mcmsg", "此角色名称已存在");
			model.addAttribute("addmsg", "角色添加失败");
			model.addAttribute("role", record);
			return "role/add";
		} else {// 添加成功
			roleservice.addrole(record);
			return "redirect:list?waymsg=add";
		}
	}

	/**
	 * 修改角色
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		role = roleservice.getrole(Integer.valueOf(request.getParameter("id"))).get(0);
		model.addAttribute("role", role);
		return "role/edit";
	}

	/**
	 * 执行修改角色
	 */
	@RequestMapping("/doedit")
	public String doedit(HttpServletRequest request, Role record, Model model) {
		rolelist = roleservice.checkrepeat(record);
		String[] mlist = request.getParameterValues("menutree");
		if (rolelist.size() > 0) {
			// 修改失败
			model.addAttribute("mcmsg", "此角色名称已存在");
			model.addAttribute("editmsg", "角色修改失败");
			model.addAttribute("role", record);
			return "role/edit";
		} else {// 修改成功
			roleservice.updaterole(record);
			return "redirect:list?waymsg=edit";
		}
	}

	/**
	 * 删除角色
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		roleservice.deleterole(Integer.valueOf(request.getParameter("id")));
		return "redirect:list?waymsg=delete";
	}
	
	/**
	 * 搜索角色
	 */
	@RequestMapping("/search")
	public String search(String searchword, Model model) {
		role = new Role();
		role.setRole_name(searchword);
		rolelist = roleservice.searchrole(role);
		model.addAttribute("rolelist", rolelist);
		return "role/list";
	}
	
}
