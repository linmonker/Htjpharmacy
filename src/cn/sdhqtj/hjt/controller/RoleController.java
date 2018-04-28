package cn.sdhqtj.hjt.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.sdhqtj.hjt.entity.AccessNode;
import cn.sdhqtj.hjt.entity.Login;
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

		// 操作提示信息
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
	 * 获取权限菜单列表
	 */
	@RequestMapping("/menulist")
	@ResponseBody
	public String menulist() {
		List<MenuNode> mlist = roleservice.getmenunodes();
		String str = JSON.toJSON(mlist).toString();
		return str;
	}
	
	/**
	 * 据角色id获取角色权限
	 */
	@RequestMapping("/getquanxian")
	@ResponseBody
	public String getquanxian(@RequestParam(value = "id") Integer id) {
		List<AccessNode> alist = roleservice.getquanxian(id);
		String str = JSON.toJSON(alist).toString();
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
	public String doadd(HttpServletRequest request, Role record, Model model, HttpSession session) {
		if (record.getRole_name() == null) {
			// 角色名称不能为空
			model.addAttribute("mcmsg", "此角色名称不能为空");
			model.addAttribute("addmsg", "角色添加失败");
			model.addAttribute("role", record);
			return "role/add";
		}
		rolelist = roleservice.checkrepeat(record);
		if (rolelist.size() > 0) {
			// 添加失败，角色名称不能重复
			model.addAttribute("mcmsg", "此角色名称已存在");
			model.addAttribute("addmsg", "角色添加失败");
			model.addAttribute("role", record);
			return "role/add";
		}
		// 添加成功
		Login login = (Login) session.getAttribute("loginer");
		record.setUser_id_create(Long.valueOf(login.getId()));
		Integer roleid = roleservice.addrole(record);
		// 获取前端权限useableid字符串
		String quanxians = request.getParameter("quanxians");
		String[] marr = quanxians.split(",");
		AccessNode an = new AccessNode();
		List<AccessNode> alist = new ArrayList<AccessNode>();
		for (int i = 0; i < marr.length; i++) {
			an.setId(Integer.valueOf(marr[i]));
			an.setRoleid(roleid);
			alist.add(an);
		}
		// 先根据角色role_id删除所有权限
		roleservice.deletequanxian(roleid);
		// 再重新添加角色权限
		roleservice.addquanxian(alist);
		return "redirect:list?waymsg=add";
	}

	/**
	 * 修改角色
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		role = roleservice.getrole(Integer.valueOf(request.getParameter("id")));
		model.addAttribute("role", role);
		return "role/edit";
	}

	/**
	 * 执行修改角色
	 */
	@RequestMapping("/doedit")
	public String doedit(HttpServletRequest request, Role record, Model model) {
		if (record.getRole_name() == null) {
			// 角色名称不能为空
			model.addAttribute("mcmsg", "此角色名称不能为空");
			model.addAttribute("editmsg", "角色修改失败");
			model.addAttribute("role", record);
			return "role/add";
		}
		role = roleservice.getrole(record.getRole_id());
		// 判断角色名称修改
		if (!role.getRole_name().equals(record.getRole_name())) {
			rolelist = roleservice.checkrepeat(record);
			if (rolelist.size() > 0) {
				// 修改失败，角色名称不能重复
				model.addAttribute("mcmsg", "此角色名称已存在");
				model.addAttribute("editmsg", "角色修改失败");
				model.addAttribute("role", record);
				return "role/edit";
			}
		}
		// 修改成功
		try {
			record.setGmt_modified(new Date());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		roleservice.updaterole(record);
		// 获取前端权限useableid字符串
		String quanxians = request.getParameter("quanxians");
		String[] marr = quanxians.split(",");
		AccessNode an = new AccessNode();
		List<AccessNode> alist = new ArrayList<AccessNode>();
		for (int i = 0; i < marr.length; i++) {
			an.setId(Integer.valueOf(marr[i]));
			an.setRoleid(record.getRole_id());
			alist.add(an);
		}
		// 先根据角色role_id删除所有权限
		roleservice.deletequanxian(record.getRole_id());
		// 再重新添加角色权限
		roleservice.addquanxian(alist);
		return "redirect:list?waymsg=edit";
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
