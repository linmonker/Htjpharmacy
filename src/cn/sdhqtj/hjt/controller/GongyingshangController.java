/**  
* Title: test.java  
* Description:  
* @author LIN  
* @date 2018年3月19日  
*/
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

@Controller
@RequestMapping("/gongyingshang")
public class GongyingshangController {

	@Resource
	GongyingshangService gysservice;
	List<Gongyingshang> gyslist;
	Gongyingshang gystemp;
	GongyingshangWithBLOBs gysBtemp;

	// 列表
	@RequestMapping("/list")
	public String list(Model model) {
		gyslist = gysservice.gongyingshangquery();
		model.addAttribute("gyslist", gyslist);
		return "gongyingshang/list";
	}

	// 新增供应商
	@RequestMapping("/add")
	public String add() {

		return "gongyingshang/add";
	}

	// 执行添加供应商
	@RequestMapping("/doadd")
	public String doadd(GongyingshangWithBLOBs gysB, Model model) {
		int fo = 1;
		gystemp = gysservice.selectBygysbhWithBLOBs(gysB.getGysbh());

		if (gystemp != null) {
			model.addAttribute("bhdate", "此供应商编号已存在");
			fo = 0;
		}
		if (fo == 0) {// 添加失败
			model.addAttribute("gys", gysB);
			return "gongyingshang/add";
		} else {
			gysB.setZt(0);
			gysB.setDm(0);
			gysservice.gongyingshangadd(gysB);
			model.addAttribute("adddate", "分店添加成功");
			return "redirect:list.action";
		}
	}

	// 修改分店
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		gysBtemp = gysservice.selectByPrimaryKey(Integer.valueOf(request.getParameter("id")));
		if (gysBtemp == null) {
			model.addAttribute("editdate", "修改失败，数据已被删除");
			return "redirect:list.action";
		} else {
			model.addAttribute("gys", gystemp);
			return "gongyingshang/edit";
		}
	}

	// 执行修改分店
	@RequestMapping("/doedit")
	public String doedit(GongyingshangWithBLOBs gysB, Model model) {
		gysB.setZt(0);
		gysB.setDm(0);
		gysservice.gongyingshangupdate(gysB);
		model.addAttribute("editdate", "修改成功");
		return "redirect:list.action";

	}

	// 删除分店
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		gysservice.gongyingshangdelete(Integer.valueOf(request.getParameter("id")));
		model.addAttribute("deletedate", "删除成功");
		return "redirect:list.action";
	}
}
