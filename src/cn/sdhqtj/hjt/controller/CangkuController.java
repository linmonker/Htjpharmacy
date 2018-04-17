package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Cangku;
import cn.sdhqtj.hjt.entity.Fendian;
import cn.sdhqtj.hjt.service.CangkuService;
import cn.sdhqtj.hjt.service.FendianService;

/**
 * 仓库controller
 */
@Controller
@RequestMapping("/cangku")
public class CangkuController {

	@Resource
	FendianService fendianservice;
	List<Fendian> fendianlist;
	Fendian fendian;

	@Resource
	CangkuService cangkuservice;
	List<Cangku> cangkulist;
	Cangku cangku;

	/**
	 * 仓库管理首页分店列表
	 */
	@RequestMapping("/sylist")
	public String sylist(Model model) {
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("fendianlist", fendianlist);
		return "cangku/sylist";
	}

	/**
	 * 仓库列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		Integer fdid = Integer.valueOf(request.getParameter("fdid"));
		cangkulist = cangkuservice.cangkuquery(fdid);
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("cangkulist", cangkulist);
		model.addAttribute("fendianlist", fendianlist);

		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("addmsg", "分店添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "分店修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "分店删除成功");
		}
		return "cangku/list";
	}

	/**
	 * 新增仓库
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		Integer fdid = Integer.valueOf(request.getParameter("fdid"));
		cangku = new Cangku();
		cangku.setFdid(fdid);
		model.addAttribute("cangku", cangku);
		return "cangku/add";
	}

	/**
	 * 执行添加仓库
	 */
	@RequestMapping("/doadd")
	public String doadd(HttpServletRequest request, Cangku record, Model model) {
		cangku = cangkuservice.checkrepeat(record);
		if (cangku != null) {
			// 添加失败
			model.addAttribute("bhmsg", "此仓库编号已存在");
			model.addAttribute("addmsg", "仓库添加失败");
			model.addAttribute("cangku", record);
			return "cangku/add";
		} else {
			// 添加成功
			cangkuservice.addcangku(record);
			return "redirect:list.action?waymsg=add";
		}
	}

	/**
	 * 修改仓库
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		Integer fdid = Integer.valueOf(request.getParameter("fdid"));
		cangku = cangkuservice.getcangku(fdid);
		model.addAttribute("cangku", cangku);
		return "cangku/edit";
	}

	/**
	 * 执行修改仓库
	 */
	@RequestMapping("/doedit")
	public String doedit(Cangku record, Model model) {
		cangku = cangkuservice.checkrepeat(record);
		if (cangku != null) {
			// 修改失败
			model.addAttribute("bhmsg", "此仓库编号已存在");
			model.addAttribute("editmsg", "仓库修改失败");
			model.addAttribute("cangku", record);
			return "cangku/edit";
		} else {
			// 修改成功
			cangkuservice.updatecangku(record);
			return "redirect:list.action?waymsg=edit";
		}
	}

	/**
	 * 删除仓库
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		cangkuservice.deletecangku(id);
		return "redirect:list.action?waymsg=delete";
	}
}
