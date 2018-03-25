package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Keshi;
import cn.sdhqtj.hjt.service.KeshiService;

@Controller
@RequestMapping("/keshi")
public class KeshiController {

	@Resource
	KeshiService keshiservice;
	List<Keshi> keshilist;
	Keshi keshi;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, HttpSession session) {
		/*
		 * try { Login login = (Login) session.getAttribute("loginer"); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		keshilist = keshiservice.keshiquery(1);
		model.addAttribute("keshilist", keshilist);
		String adddata = (String) request.getAttribute("adddata");
		if (adddata != null) {
			adddata = "添加成功";
			model.addAttribute("adddate", adddata);
		}
		String deletedata = (String) request.getAttribute("deletedata");
		if (deletedata != null) {
			deletedata = "删除成功";
			model.addAttribute("deletedata", deletedata);
		}
		return "keshi/list";
	}

	/**
	 * 新增科室
	 */
	@RequestMapping("/add")
	public String add() {

		return "keshi/add";
	}

	/**
	 * 执行添加科室
	 */
	@RequestMapping("/doadd")
	public String doadd(Keshi record, Model model) {
		keshilist = keshiservice.checkrepeat(record);

		if (keshilist.size() > 0) {
			for (Keshi kstemp : keshilist) {
				if (kstemp.getKsbh() != null) {
					model.addAttribute("bhdate", "此科室编号已存在");
				}
				if (kstemp.getKsmc() != null) {
					model.addAttribute("mcdate", "此科室名称已存在");
				}
			}
			model.addAttribute("keshi", keshi);
			return "keshi/add";
		} else {
			keshiservice.keshiadd(record);
			return "redirect:list.action";
		}
	}

	/**
	 * 修改科室
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		keshi = keshiservice.keshiget(id);
		model.addAttribute("keshi", keshi);
		return "keshi/edit";
	}

	/**
	 * 执行修改科室
	 */
	@RequestMapping("/doedit")
	public String doedit(Keshi record, Model model) {
		keshilist = keshiservice.checkrepeat(record);

		if (keshilist.size() > 0) {
			for (Keshi kstemp : keshilist) {
				if (kstemp.getKsbh() != null) {
					model.addAttribute("bhdate", "此科室编号已存在");
				}
				if (kstemp.getKsmc() != null) {
					model.addAttribute("mcdate", "此科室名称已存在");
				}
			}
			model.addAttribute("keshi", keshi);
			return "keshi/edit";
		} else {
			keshiservice.keshiupdate(keshi);
			return "redirect:list.action?adddata=1";
		}

	}

	/**
	 * 删除科室
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		keshiservice.keshidelete(id);
		model.addAttribute("deletedate", "删除成功");
		return "redirect:list.action?deletedata=1";
	}
}
