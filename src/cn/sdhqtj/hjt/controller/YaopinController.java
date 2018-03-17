package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;
import cn.sdhqtj.hjt.service.YaopinService;

@Controller
@RequestMapping("/yaopin")
public class YaopinController {

	@Resource
	YaopinService yaopinservice;
	List<Yaopin> yaopinlist;
	Yaopin yaopintemp;
	YaopinWithBLOBs yaopinBtemp;

	// 列表
	@RequestMapping("/list")
	public String list(Model model) {
		yaopinlist = yaopinservice.yaopinquery();

		model.addAttribute("yaopinnlist", yaopinlist);

		return "yaopin/list";
	}

	// 新增药品
	@RequestMapping("/add")
	public String add() {

		return "yaopin/add";
	}

	// 执行添加药品
	@RequestMapping("/doadd")
	public String doadd(YaopinWithBLOBs yaopin, Model model) {
		int fo = 1;
		yaopinBtemp = yaopinservice.selectByypbh(yaopin.getYpbh());

		if (yaopinBtemp != null) {
			model.addAttribute("bhdate", "此药品编号已存在");
			fo = 0;
		}
		if (fo == 0) {// 添加失败
			model.addAttribute("yaopin", yaopin);
			return "yaopin/add";
		}
		else {
			yaopin.setZt(0);
			yaopinservice.yaopinadd(yaopin);
			model.addAttribute("adddate", "药品添加成功");
			return "redirect:list.action";
		}
	}
	
	// 修改分店
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,Model model) {
		String ypbh = request.getParameter("ypbh");
		yaopinBtemp = yaopinservice.selectByypbh(ypbh);
		model.addAttribute("yaopin", yaopinBtemp);
		return "yaopin/edit";
	}
	
	// 执行修改分店
	@RequestMapping("/doedit")
	public String doedit(YaopinWithBLOBs yaopin,Model model) {
		yaopin.setZt(0);
		yaopinservice.yaopinUpdate(yaopin);
		model.addAttribute("editdate", "修改成功");
		return "redirect:list.action";
		
	}
    
	// 删除分店
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model) {
		
		yaopinBtemp = yaopinservice.selectByypbh(request.getParameter("ypbh"));
		yaopinservice.yaopindelete(yaopinBtemp.getId());
		model.addAttribute("deletedate", "删除成功");
		return "redirect:list.action";
	}

}
