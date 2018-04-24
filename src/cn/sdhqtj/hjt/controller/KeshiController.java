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
import cn.sdhqtj.hjt.entity.Login;

/**
 * 科室controller
 */
@Controller
@RequestMapping("/keshi")
public class KeshiController {

	@Resource
	KeshiService keshiservice;
	List<Keshi> keshilist;
	Keshi keshi;

	Login login;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, HttpSession session) {

	    login = (Login) session.getAttribute("loginer");
		keshilist = keshiservice.keshiquery(login.getFdid());
		model.addAttribute("keshilist", keshilist);

		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("addmsg", "分店添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "分店修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "分店删除成功");
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
	public String doadd(Keshi record, Model model, HttpSession session) {
		keshilist = keshiservice.checkrepeat(record);

		if (keshilist.size() > 0) {
			model.addAttribute("bhmsg", "此科室编号已存在");
			model.addAttribute("keshi", record);
			return "keshi/add";
		} else {
			login = (Login) session.getAttribute("longiner");
			record.setFdid(login.getFdid());
			keshiservice.addkeshi(record);
			return "redirect:list?waymsg=add";
		}
	}

	/**
	 * 修改科室
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		keshi = keshiservice.getkeshi(id);
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
			model.addAttribute("bhmsg", "此科室编号已存在");
			model.addAttribute("keshi", keshi);
			return "keshi/edit";
		} else {
			keshiservice.updatekeshi(keshi);
			return "redirect:list?waymsg=edit";
		}
	}

	/**
	 * 删除科室
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		keshiservice.deletekeshi(id);
		return "redirect:list?waymsg=delete";
	}
	
	/**
	 * 搜索科室
	 */
	@RequestMapping("/search")
	public String search(String searchword, Model model, HttpSession session) {
		keshi = new Keshi();
	    login = (Login) session.getAttribute("loginer");
	    keshi.setFdid(login.getFdid());
	    keshi.setKsmc(searchword);
		keshilist = keshiservice.searchkeshi(keshi);
		model.addAttribute("keshilist", keshilist);
		return "keshi/list";
	}
}
