package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.entity.Zuzhijigou;
import cn.sdhqtj.hjt.service.ChushiService;

@Controller
@RequestMapping("/zuzhijigou")
public class ChushiController {

	@Resource
	ChushiService chushiservice;
	List<Zuzhijigou> chushilist;
	Zuzhijigou chushi;

	Login login;
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, HttpSession session) {
		login = (Login) session.getAttribute("loginer"); 
		chushilist = chushiservice.chushiquery(login.getFdid());
		model.addAttribute("chushilist", chushilist);
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("addmsg", "分店添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "分店修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "分店删除成功");
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
	public String doadd(Zuzhijigou record, Model model, HttpSession session) {
		chushilist = chushiservice.checkrepeat(record);

		if (chushilist.size() > 0) {
			model.addAttribute("bhmsg", "此处室编号已存在");
			model.addAttribute("chushi", record);
			return "zuzhijigou/add";
		} else {
			login = (Login) session.getAttribute("loginer");
			record.setFdid(login.getFdid());
			chushiservice.addchushi(record);
			return "redirect:list.action?waymsg=add";
		}
	}

	/**
	 * 修改科室
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		chushi = chushiservice.getchushi(id);
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
			model.addAttribute("bhmsg", "此科室编号已存在");
			model.addAttribute("chushi", record);
			return "zuzhijigou/edit";
		} else {
			chushiservice.updatechushi(record);
			return "redirect:list.action?waymsg=edit";
		}

	}

	/**
	 * 删除科室
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		chushiservice.deletechushi(id);
		return "redirect:list.action?waymsg=delete";
	}
}
