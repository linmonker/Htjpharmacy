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
import cn.sdhqtj.hjt.entity.YaopinVo;
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
	List<YaopinVo> yaopinvolist;
	Yaopin yaopin;
	List<Yaopin> yaopinlist;
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
		yaopinvolist = yaopinservice.yaopinquery();
		model.addAttribute("yaopinlist", yaopinvolist);

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("addmsg", "药品添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "药品修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "药品删除成功");
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
		if (record.getYpbh() == null || record.getYpspm() == null) {
			// 添加失败，药品编号、药品名称不能为空
			model.addAttribute("addmsg", "药品添加失败");
			model.addAttribute("bhmsg", "药品编号不能为空");
			model.addAttribute("mcmsg", "药品名称不能为空");
			model.addAttribute("yaopin", record);
			return "yaopin/add";
		}
		yaopinlist = yaopinservice.checkrepeat(record.getYpbh());
		if (yaopinlist.size() > 0) {
			// 添加失败,药品编号不能重复
			model.addAttribute("bhmsg", "此药品编号已存在");
			model.addAttribute("addmsg", "药品添加失败");
			model.addAttribute("yaopin", record);

			ypfllist = ypflservice.Yaopinfenleiquery();
			gyslist = gysservice.gongyingshangquery();
			model.addAttribute("ypfllist", ypfllist);
			model.addAttribute("gyslist", gyslist);

			return "yaopin/add";
		}
		// 添加成功
		Login loginer = (Login) session.getAttribute("loginer");
		record.setYpcjr(loginer.getId());
		yaopinservice.addyaopin(record);
		return "redirect:list?waymsg=add";
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
		if (record.getYpbh() == null || record.getYpspm() == null) {
			// 修改失败，药品编号、药品名称不能为空
			model.addAttribute("editmsg", "药品修改失败");
			model.addAttribute("bhmsg", "药品编号不能为空");
			model.addAttribute("mcmsg", "药品名称不能为空");
			model.addAttribute("yaopin", record);
			return "yaopin/edit";
		}
		yaopin = yaopinservice.getyaopin(record.getId());
		// 判断药品编号修改
		if (!yaopin.getYpbh().equals(record.getYpbh())) {
			yaopinlist = yaopinservice.checkrepeat(record.getYpbh());
			if (yaopinlist.size() > 0) {
				// 修改失败，药品编号不能重复
				model.addAttribute("bhmsg", "此药品编号已存在");
				model.addAttribute("editmsg", "药品修改失败");
				model.addAttribute("yaopin", record);
				
				ypfllist = ypflservice.Yaopinfenleiquery();
				gyslist = gysservice.gongyingshangquery();
				model.addAttribute("ypfllist", ypfllist);
				model.addAttribute("gyslist", gyslist);

				return "yaopin/edit";
			}
		} 
		// 修改成功
		yaopinservice.updateyaopin(record);
		return "redirect:list?waymsg=edit";	
	}

	/**
	 * 删除药品
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		yaopinservice.deleteyaopin(Integer.valueOf(request.getParameter("id")));
		return "redirect:list?waymsg=delete";
	}

	/**
	 * 搜索药品
	 */
	@RequestMapping("/search")
	public String search(String searchword, Model model) {
		yaopin = new Yaopin();
		yaopin.setYpbh(searchword);
		yaopin.setYpspm(searchword);
		yaopin.setYptym(searchword);
		yaopinvolist = yaopinservice.searchyaopin(yaopin);
		model.addAttribute("yaopinlist", yaopinvolist);
		return "yaopin/list";
	}
}
