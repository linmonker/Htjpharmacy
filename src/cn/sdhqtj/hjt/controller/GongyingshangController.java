package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;
import cn.sdhqtj.hjt.service.GongyingshangService;

/**
 * 供应商controller
 */
@Controller
@RequestMapping("/gongyingshang")
public class GongyingshangController {

	@Resource
	GongyingshangService gysservice;
	List<Gongyingshang> gyslist;
	Gongyingshang gys;
	GongyingshangWithBLOBs gysB;

	/**
	 * 供应商列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		gyslist = gysservice.gongyingshangquery();
		model.addAttribute("gyslist", gyslist);

		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("addmsg", "分店添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "分店修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "分店删除成功");
		}
		return "gongyingshang/list";
	}

	/**
	 * 新增供应商
	 */
	@RequestMapping("/add")
	public String add() {

		return "gongyingshang/add";
	}

	/**
	 * 执行添加供应商
	 */
	@RequestMapping("/doadd")
	public String doadd(GongyingshangWithBLOBs record, Model model) {
		gys = gysservice.checkrepeat(record);

		if (record.getGysbh() == null || record.getGysmc() == null || gys != null) {
			// 添加失败
			if (gys != null) {
				model.addAttribute("bhmsg", "此供应商编号已存在");
			}
			model.addAttribute("addmsg", "供应商添加失败");
			model.addAttribute("gys", record);
			return "gongyingshang/add";
		} else {// 添加成功
			gysservice.addgongyingshang(record);
			return "redirect:list?waymsg=add";
		}
	}

	/**
	 * 修改供应商
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		gysB = gysservice.selectByPrimaryKey(Integer.valueOf(request.getParameter("id")));
		model.addAttribute("gys", gysB);
		return "gongyingshang/edit";
	}

	/**
	 * 执行修改供应商
	 */
	@RequestMapping("/doedit")
	public String doedit(GongyingshangWithBLOBs record, Model model) {
		gys = gysservice.checkrepeat(record);

		if (record.getGysbh() == null || record.getGysmc() == null || gys != null) {
			// 修改失败
			if (gys != null) {
				model.addAttribute("bhmsg", "此供应商编号已存在");
			}
			model.addAttribute("addmsg", "供应商添加失败");
			model.addAttribute("gys", record);
			return "gongyingshang/edit";
		} else {// 修改成功
			gysservice.updategongyingshang(record);
			return "redirect:list?waymsg=edit";
		}
	}

	/**
	 * 删除供应商
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		gysservice.deletegongyingshang(Integer.valueOf(request.getParameter("id")));
		return "redirect:list?waymsg=delete";
	}
	
	@RequestMapping("/search")
	public String search(String searchword, Model model) {
		gys = new Gongyingshang();
		gys.setGysbh(searchword);
		gys.setGysmc(searchword);
		gyslist = gysservice.searchgongyingshang(gys);
		model.addAttribute("gyslist", gyslist);
		return "gongyingshang/list";
	}
}
