package cn.sdhqtj.hjt.controller;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

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
	 * 角色列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		// 获取分页信息
		int conpage = 1;
		String conpagestr = request.getParameter("conpage");
		if (conpagestr != null) {
			conpage = Integer.valueOf(conpagestr);
		}
		model.addAttribute("conpage", conpage);
		model.addAttribute("count", roleservice.getcount());

		rolelist = roleservice.getlist((conpage - 1) * 20);
		model.addAttribute("rolelist", rolelist);

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("waymsg", "角色添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("waymsg", "角色修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("waymsg", "角色删除成功");
		} else if ("error".equals(waymsg)) {
			model.addAttribute("waymsg", "操作失误");
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
		String menus = JSON.toJSON(mlist).toString();
		return menus;
	}

	/**
	 * 据角色id获取角色权限
	 */
	@RequestMapping("/getquanxian")
	@ResponseBody
	public String getquanxian(@RequestParam(value = "id") int id) {
		List<AccessNode> alist = roleservice.getquanxian(id);
		String quanxians = JSON.toJSON(alist).toString();
		return quanxians;
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
		// 获取前端权限useableid json字符串
		String quanxians = request.getParameter("quanxians");
		if (record.getRole_name() == null) {
			// 角色名称不能为空
			model.addAttribute("mcmsg", "此角色名称不能为空");
			model.addAttribute("waymsg", "角色添加失败");
			model.addAttribute("role", record);
			quanxians = quanxians.replaceAll("\"", "&quot;");
			model.addAttribute("quanxians", quanxians);
			return "role/add";
		}

		// 检查重复
		rolelist = roleservice.checkrepeat(record);
		if (rolelist.size() > 0) {
			// 添加失败，角色名称不能重复
			model.addAttribute("mcmsg", "此角色名称已存在");
			model.addAttribute("waymsg", "角色添加失败");
			model.addAttribute("role", record);
			quanxians = quanxians.replaceAll("\"", "&quot;");
			model.addAttribute("quanxians", quanxians);
			return "role/add";
		}

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		Login login = (Login) session.getAttribute("loginer");
		record.setUser_id_create(Long.valueOf(login.getId()));
		int roleid = roleservice.addrole(record);
		if (roleid > 0) {
			// 添加成功
			// 将权限json字符串转换成Java对象list
			List<AccessNode> alist = JSON.parseObject(quanxians, new TypeReference<ArrayList<AccessNode>>() {
			});
			for (AccessNode temp : alist) {
				temp.setRoleid(roleid);
			}
			// 先根据角色role_id删除所有权限
			roleservice.deletequanxian(roleid);
			// 再重新添加角色权限
			roleservice.addquanxian(alist);
			return "redirect:list?waymsg=add";
		} else {
			// 添加失败
			model.addAttribute("waymsg", "角色添加失败");
			model.addAttribute("role", record);
			quanxians = quanxians.replaceAll("\"", "&quot;");
			model.addAttribute("quanxians", quanxians);
			return "role/add";
		}
	}

	/**
	 * 修改角色
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		int id = Integer.valueOf(request.getParameter("id"));
		role = roleservice.getrole(id);
		model.addAttribute("role", role);

		// 获取角色权限
		List<AccessNode> alist = roleservice.getquanxian(id);
		String quanxians = JSON.toJSON(alist).toString();
		quanxians = quanxians.replaceAll("\"", "&quot;");
		model.addAttribute("quanxians", quanxians);
		return "role/edit";
	}

	/**
	 * 执行修改角色
	 */
	@RequestMapping("/doedit")
	public String doedit(HttpServletRequest request, Role record, Model model) {
		// 获取前端权限useableid json字符串
		String quanxians = request.getParameter("quanxians");
		if (record.getRole_name() == null) {
			// 角色名称不能为空
			model.addAttribute("mcmsg", "此角色名称不能为空");
			model.addAttribute("waymsg", "角色修改失败");
			model.addAttribute("role", record);
			quanxians = quanxians.replaceAll("\"", "&quot;");
			model.addAttribute("quanxians", quanxians);
			return "role/add";
		}

		// 检查重复
		rolelist = roleservice.checkrepeat(record);
		if (rolelist.size() > 0) {
			// 修改失败，角色名称不能重复
			model.addAttribute("mcmsg", "此角色名称已存在");
			model.addAttribute("waymsg", "角色修改失败");
			model.addAttribute("role", record);
			quanxians = quanxians.replaceAll("\"", "&quot;");
			model.addAttribute("quanxians", quanxians);
			return "role/edit";
		}

		try {
			record.setGmt_modified(new Date());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int res = roleservice.updaterole(record);
		if (res >= 0) {
			// 修改成功
			// 将权限json字符串转换成Java对象list
			List<AccessNode> alist = JSON.parseObject(quanxians, new TypeReference<ArrayList<AccessNode>>() {
			});
			for (AccessNode temp : alist) {
				temp.setRoleid(record.getRole_id());
			}
			// 先根据角色role_id删除所有权限
			roleservice.deletequanxian(record.getRole_id());
			// 再重新添加角色权限
			roleservice.addquanxian(alist);
			return "redirect:list?waymsg=edit";
		} else {
			// 修改失败
			model.addAttribute("waymsg", "角色修改失败");
			model.addAttribute("role", record);
			quanxians = quanxians.replaceAll("\"", "&quot;");
			model.addAttribute("quanxians", quanxians);
			return "role/edit";
		}
	}

	/**
	 * 删除角色
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		int res = roleservice.deleterole(Integer.valueOf(request.getParameter("id")));
		if (res > 0) {
			// 删除成功
			return "redirect:list?waymsg=delete";
		} else {
			// 删除失败
			return "redirect:list?waymsg=error";
		}
	}

	/**
	 * 搜索角色
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		String searchword = request.getParameter("searchword");
		// 获取分页信息
		int conpage = 1;
		String conpagestr = request.getParameter("conpage");
		if (conpagestr != null) {
			conpage = Integer.valueOf(conpagestr);
		}
		model.addAttribute("conpage", conpage);
		model.addAttribute("searchword", searchword);

		role = new Role();
		role.setRole_name(searchword);
		rolelist = roleservice.searchrole(role, (conpage - 1) * 20);
		model.addAttribute("rolelist", rolelist);
		model.addAttribute("count", roleservice.getsearchcount(role));
		return "role/searchlist";
	}

	/**
	 * 下载角色列表Excel
	 */
	@RequestMapping("/downloadexcel")
	public ResponseEntity<byte[]> downloadexcel() throws Exception {
		String path = roleservice.writeexcel();
		File file = new File(path);
		String fileName = new String("角色列表.xlsx".getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

}
