package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Fendian;
import cn.sdhqtj.hjt.service.FendianService;

@Controller
@RequestMapping("/fendian")
public class FendianController {

	@Resource
	FendianService fendianservice;
	List<Fendian> fendianlist;
	Fendian fendiantemp;

	// 列表
	@RequestMapping("/list")
	public String list(Model model) {
		fendianlist = fendianservice.fendianquery();

		model.addAttribute("fendianlist", fendianlist);

		return "fendian/list";
	}

	// 新增分店
	@RequestMapping("/add")
	public String add() {

		return "fendian/add";
	}

	// 执行添加分店
	@RequestMapping("/doadd")
	public String doadd(Fendian fendian, Model model) {
		int fo = 1;
		fendiantemp = fendianservice.selectByfdbh(fendian.getFdbh());

		if (fendiantemp != null) {
			model.addAttribute("bhdate", "此分店编号已存在");
			fo = 0;
		}
		fendiantemp = fendianservice.selectByfdmc(fendian.getFdmc());
		if (fendiantemp != null) {
			model.addAttribute("mcdate", "此分店名称已存在");
			fo = 0;
		}
		if (fo == 0) {// 添加失败
			model.addAttribute("fendian", fendian);
			return "fendian/add";
		}
		else {
			fendian.setZt(0);
			fendianservice.fendianadd(fendian);
			model.addAttribute("adddate", "分店添加成功");
			return "redirect:list.action";
		}
	}
	
	// 修改分店
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,Model model) {
		String fdbh = request.getParameter("fdbh");
		fendiantemp = fendianservice.selectByfdbh(fdbh);
		model.addAttribute("fendian", fendiantemp);
		return "fendian/edit";
	}
	
	// 执行修改分店
	@RequestMapping("/doedit")
	public String doedit(Fendian fendian,Model model) {
		fendian.setZt(0);
		fendianservice.fendianUpdate(fendian);
		model.addAttribute("editdate", "修改成功");
		return "redirect:list.action";
		
	}
    
	// 删除分店
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model) {
		
		fendiantemp = fendianservice.selectByfdbh(request.getParameter("fdbh"));
		fendianservice.fendiandelete(fendiantemp.getId());
		model.addAttribute("deletedate", "删除成功");
		return "redirect:list.action";
	}

}
