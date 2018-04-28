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

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("addmsg", "供应商添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "供应商修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "供应商删除成功");
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
		if (record.getGysbh() == null || record.getGysmc() == null) {
			// 添加失败，供应商编号不能为空
			model.addAttribute("addmsg", "供应商添加失败");
			model.addAttribute("bhmsg", "供应商编号不能为空");
			model.addAttribute("mcmsg", "供应商名称不能为空");
			model.addAttribute("gys", record);
			return "gongyingshang/add";
		}
		gyslist = gysservice.checkrepeat(record);
		if (gyslist.size() > 0) {
			// 添加失败，供应商编号不能重复
			model.addAttribute("bhmsg", "此供应商编号已存在");
			model.addAttribute("addmsg", "供应商添加失败");
			model.addAttribute("gys", record);
			return "gongyingshang/add";
		}
		// 添加成功
		gysservice.addgongyingshang(record);
		return "redirect:list?waymsg=add";
	}

	/**
	 * 修改供应商
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		gysB = gysservice.getgongyingshang(Integer.valueOf(request.getParameter("id")));
		model.addAttribute("gys", gysB);
		return "gongyingshang/edit";
	}

	/**
	 * 执行修改供应商
	 */
	@RequestMapping("/doedit")
	public String doedit(GongyingshangWithBLOBs record, Model model) {
		if (record.getGysbh() == null || record.getGysmc() == null) {
			// 修改失败，供应商编号不能为空
			model.addAttribute("editmsg", "供应商修改失败");
			model.addAttribute("bhmsg", "供应商编号不能为空");
			model.addAttribute("mcmsg", "供应商名称不能为空");
			model.addAttribute("gys", record);
			return "gongyingshang/edit";
		}
		gys = gysservice.getgongyingshang(record.getId());
		// 判断供应商编号修改
		if (!gys.getGysbh().equals(record.getGysbh())) {
			gyslist = gysservice.checkrepeat(record);
			if (gyslist.size() > 0) {
				// 修改失败，供应商编号不能重复
				model.addAttribute("bhmsg", "此供应商编号已存在");
				model.addAttribute("editmsg", "供应商修改失败");
				model.addAttribute("gys", record);
				return "gongyingshang/edit";
			}
		}
		// 修改成功
		gysservice.updategongyingshang(record);
		return "redirect:list?waymsg=edit";
	}

	/**
	 * 删除供应商
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		gysservice.deletegongyingshang(Integer.valueOf(request.getParameter("id")));
		return "redirect:list?waymsg=delete";
	}

	/**
	 * 搜索供应商
	 */
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
