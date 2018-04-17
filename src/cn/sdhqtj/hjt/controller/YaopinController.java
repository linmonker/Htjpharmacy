package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinPro;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;
import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.service.GongyingshangService;
import cn.sdhqtj.hjt.service.YaopinService;
import cn.sdhqtj.hjt.service.YaopinfenleiService;

/**
 * 药品controller
 */
@Controller
@RequestMapping("/yaopin")
public class YaopinController {

	@Resource
	YaopinService yaopinservice;
	List<YaopinPro> yaopinlist;
	Yaopin yaopin;
	YaopinWithBLOBs yaopinB;
	
	@Resource
	YaopinfenleiService ypflservice;
	List<Yaopinfenlei> ypfllist;
	
	@Resource
	GongyingshangService gysservice;
	List<Gongyingshang> gyslist;

	/**
	 * 药品列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		yaopinlist = yaopinservice.yaopinquery();
		model.addAttribute("yaopinnlist", yaopinlist);

		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("addmsg", "分店添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "分店修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "分店删除成功");
		}
		return "yaopin/list";
	}

	/**
	 * 新增药品
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		ypfllist = ypflservice.Yaopinfenleiquery();
		gyslist = gysservice.gongyingshangquery();
		model.addAttribute("ypfllist", ypfllist);
		model.addAttribute("gyslist", gyslist);
		return "yaopin/add";
	}

	/**
	 * 执行添加药品
	 */
	@RequestMapping("/doadd")
	public String doadd(YaopinWithBLOBs record, Model model, HttpSession session) {
		yaopin = yaopinservice.checkrepeat(record.getYpbh());

		if (record.getYpbh() == null || record.getYpspm() == null || yaopin != null) {
			// 添加失败
			if (yaopin != null) {
				model.addAttribute("bhmsg", "此药品编号已存在");
			}
			ypfllist = ypflservice.Yaopinfenleiquery();
			gyslist = gysservice.gongyingshangquery();
			model.addAttribute("ypfllist", ypfllist);
			model.addAttribute("gyslist", gyslist);
			
			model.addAttribute("addmsg", "药品添加失败");
			model.addAttribute("yaopin", record);
			return "yaopin/add";
		} else {// 添加成功
			Login loginer = (Login) session.getAttribute("loginer");
			record.setYpcjr(loginer.getId());
			yaopinservice.addyaopin(record);
			return "redirect:list.action?waymsg=add";
		}
	}

	/**
	 * 修改药品
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		yaopinB = yaopinservice.getyaopin(Integer.valueOf(request.getParameter("id")));
		model.addAttribute("yaopin", yaopinB);
		
		ypfllist = ypflservice.Yaopinfenleiquery();
		gyslist = gysservice.gongyingshangquery();
		model.addAttribute("ypfllist", ypfllist);
		model.addAttribute("gyslist", gyslist);
		return "yaopin/edit";
	}

	/**
	 * 执行修改药品
	 */
	@RequestMapping("/doedit")
	public String doedit(YaopinWithBLOBs record, Model model) {
		yaopin = yaopinservice.checkrepeat(record.getYpbh());

		if (record.getYpbh() == null || record.getYpspm() == null || yaopin != null) {
			// 修改失败
			if (yaopin != null) {
				model.addAttribute("bhmsg", "此药品编号已存在");
			}
			ypfllist = ypflservice.Yaopinfenleiquery();
			gyslist = gysservice.gongyingshangquery();
			model.addAttribute("ypfllist", ypfllist);
			model.addAttribute("gyslist", gyslist);
			
			model.addAttribute("addmsg", "药品添加失败");
			model.addAttribute("yaopin", record);
			return "yaopin/edit";
		} else {// 修改成功
			yaopinservice.updateyaopin(record);
			return "redirect:list.action?waymsg=edit";
		}
	}

	/**
	 * 删除药品
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		yaopinservice.deleteyaopin(Integer.valueOf(request.getParameter("id")));
		return "redirect:list.action?waymsg=delete";
	}

}
