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

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("addmsg", "科室添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "科室修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "科室删除成功");
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
		if (record.getKsbh() == null || record.getKsmc() == null) {
			// 添加失败，科室编号、科室名称不能为空
			model.addAttribute("addmsg", "科室添加失败");
			model.addAttribute("bhmsg", "科室编号不能为空");
			model.addAttribute("mcmsg", "科室名称不能为空");
			model.addAttribute("keshi", record);
			return "keshi/add";
		}
		keshilist = keshiservice.checkrepeat(record);
		if (keshilist.size() > 0) {
			// 添加失败，科室编号不能重复
			model.addAttribute("bhmsg", "此科室编号已存在");
			model.addAttribute("addmsg", "科室添加失败");
			model.addAttribute("keshi", record);
			return "keshi/add";
		}
		// 添加成功
		keshiservice.addkeshi(record);
		return "redirect:list?waymsg=add";
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
		if (record.getKsbh() == null || record.getKsmc() == null) {
			// 修改失败，科室编号、科室名称不能为空
			model.addAttribute("editmsg", "科室修改失败");
			model.addAttribute("bhmsg", "科室编号不能为空");
			model.addAttribute("mcmsg", "科室名称不能为空");
			model.addAttribute("keshi", record);
			return "keshi/edit";
		}
		keshi = keshiservice.getkeshi(record.getId());
		// 判断科室编号修改
		if (!keshi.getKsbh().equals(record.getKsbh())) {
			keshilist = keshiservice.checkrepeat(record);
			if (keshilist.size() > 0) {
				// 科室编号不能重复
				model.addAttribute("bhmsg", "此科室编号已存在");
				model.addAttribute("editmsg", "科室修改失败");
				model.addAttribute("keshi", record);
				return "keshi/edit";
			}
		}
		// 修改成功
		keshiservice.updatekeshi(keshi);
		return "redirect:list?waymsg=edit";
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
