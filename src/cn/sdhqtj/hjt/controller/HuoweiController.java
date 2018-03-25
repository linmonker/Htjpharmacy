package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Huowei;
import cn.sdhqtj.hjt.service.HuoweiService;

@Controller
@RequestMapping("/huowei")
public class HuoweiController {
	
	@Resource
	HuoweiService huoweiservice;
	List<Huowei> huoweilist;
	Huowei huowei;

	// 货位列表
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		Integer ckid = Integer.valueOf(request.getParameter("id"));
		huoweilist = huoweiservice.huoweiquery(ckid);
		model.addAttribute("huoweilist", huoweilist);
		model.addAttribute("ckid", ckid);

		return "huowei/list";
	}

	// 新增货位
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		Integer ckid = Integer.valueOf(request.getParameter("id"));
		model.addAttribute("ckid", ckid);

		return "huowei/add";
	}

	// 执行添加货位
	@RequestMapping("/doadd")
	public String doadd(Huowei record, Model model,HttpSession session) {
		record.setFdid((Integer) session.getAttribute("fdid")); 
		huoweiservice.huoweiadd(record);
		model.addAttribute("adddate", "货位添加成功");
		return "redirect:list.action";
	}

	// 修改货位
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		huowei = huoweiservice.huoweiget(id);
		model.addAttribute("huowei", huowei);
		return "huowei/edit";
	}

	// 执行修改货位
	@RequestMapping("/doedit")
	public String doedit(Huowei record, Model model) {
		huoweiservice.huoweiupdate(record);
		model.addAttribute("editdate", "修改成功");
		return "redirect:list.action";
	}

	// 删除货位
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		huoweiservice.huoweidelete(id);
		model.addAttribute("deletedate", "删除成功");
		return "redirect:list.action";
	}
}
