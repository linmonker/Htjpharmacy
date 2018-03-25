package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Zuzhijigou;
import cn.sdhqtj.hjt.service.ChushiService;

@Controller
@RequestMapping("/zuzhijigou")
public class ChushiController {

	@Resource
	ChushiService chushiservice;
	List<Zuzhijigou> chushilist;
	Zuzhijigou chushi;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, HttpSession session) {
		/*
		 * try { Login login = (Login) session.getAttribute("loginer"); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		chushilist = chushiservice.chushiquery(1);
		model.addAttribute("chushilist", chushilist);
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
		return "zuzhijigou/list";
	}

	/**
	 * 新增科室
	 */
	@RequestMapping("/add")
	public String add() {

		return "zuzhijigou/add";
	}

	/**
	 * 执行添加科室
	 */
	@RequestMapping("/doadd")
	public String doadd(Zuzhijigou record, Model model) {
		chushilist = chushiservice.checkrepeat(record);

		if (chushilist.size() > 0) {
			for (Zuzhijigou cstemp : chushilist) {
				if (cstemp.getCsbh() != null) {
					model.addAttribute("bhdate", "此处室编号已存在");
				}
				if (cstemp.getCsmc() != null) {
					model.addAttribute("mcdate", "此处室名称已存在");
				}
			}
			model.addAttribute("chushi", chushi);
			return "zuzhijigou/add";
		} else {
			chushiservice.chushiadd(record);
			return "redirect:list.action";
		}
	}

	/**
	 * 修改科室
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		chushi = chushiservice.chushiget(id);
		model.addAttribute("chushi", chushi);
		return "zuzhijigou/edit";
	}

	/**
	 * 执行修改科室
	 */
	@RequestMapping("/doedit")
	public String doedit(Zuzhijigou record, Model model) {
		chushilist = chushiservice.checkrepeat(record);

		if (chushilist.size() > 0) {
			for (Zuzhijigou cstemp : chushilist) {
				if (cstemp.getCsbh() != null) {
					model.addAttribute("bhdate", "此科室编号已存在");
				}
				if (cstemp.getCsmc() != null) {
					model.addAttribute("mcdate", "此科室名称已存在");
				}
			}
			model.addAttribute("chushi", chushi);
			return "zuzhijigou/edit";
		} else {
			chushiservice.chushiupdate(chushi);
			return "redirect:list.action?adddata=1";
		}

	}

	/**
	 * 删除科室
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		chushiservice.chushidelete(id);
		model.addAttribute("deletedate", "删除成功");
		return "redirect:list.action?deletedata=1";
	}
}
