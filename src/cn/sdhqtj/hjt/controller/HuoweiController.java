package cn.sdhqtj.hjt.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.sdhqtj.hjt.entity.Huowei;
import cn.sdhqtj.hjt.service.HuoweiService;

/**
 * 货位controller
 */
@Controller
@RequestMapping("/huowei")
public class HuoweiController {

	@Resource
	HuoweiService huoweiservice;
	List<Huowei> huoweilist;
	Huowei huowei;

	/**
	 * 货位列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		Integer ckid = Integer.valueOf(request.getParameter("id"));
		huoweilist = huoweiservice.huoweiquery(ckid);
		model.addAttribute("huoweilist", huoweilist);
		
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("addmsg", "分店添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "分店修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "分店删除成功");
		}

		return "huowei/list";
	}

	/**
	 * 新增货位
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		Integer fdid = Integer.valueOf(request.getParameter("fdid"));
		Integer ckid = Integer.valueOf(request.getParameter("ckid"));
		huowei = new Huowei();
		huowei.setFdid(fdid);
		huowei.setCkid(ckid);
		model.addAttribute("huowei", huowei);

		return "huowei/add";
	}

	/**
	 * 执行添加货位
	 */
	@RequestMapping("/doadd")
	public String doadd(Huowei record, Model model) {
		huowei = huoweiservice.checkrepeat(record);
		if(huowei != null) {
			//添加失败
			model.addAttribute("bhmsg", "此货位编号已存在");
			model.addAttribute("addmsg", "货位添加失败");
			model.addAttribute("huowei", record);
			return "huowei/add";
		}else {
			//添加成功
			huoweiservice.addhuowei(record);
		    return "redirect:list.action?waymsg=add";
		}	
	}

	/**
	 * 修改货位
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		huowei = huoweiservice.gethuowei(id);
		model.addAttribute("huowei", huowei);
		return "huowei/edit";
	}

	/**
	 * 执行修改货位
	 */
	@RequestMapping("/doedit")
	public String doedit(Huowei record, Model model) {
		huowei = huoweiservice.checkrepeat(record);
		if(huowei != null) {
			//修改失败
			model.addAttribute("bhmsg", "此货位编号已存在");
			model.addAttribute("editmsg", "货位修改失败");
			model.addAttribute("huowei", record);
			return "huowei/edit";
		}else {
			//修改成功
			huoweiservice.addhuowei(record);
		    return "redirect:list.action?waymsg=edit";
		}	
	}

	/**
	 * 删除货位
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		huoweiservice.deletehuowei(id);
		return "redirect:list.action?waymsg=delete";
	}
}
