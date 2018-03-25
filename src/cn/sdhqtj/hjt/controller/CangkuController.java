package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Cangku;
import cn.sdhqtj.hjt.entity.Fendian;
import cn.sdhqtj.hjt.service.CangkuService;
import cn.sdhqtj.hjt.service.FendianService;

@Controller
@RequestMapping("/cangku")
public class CangkuController {

	@Resource
	FendianService fendianservice;
	List<Fendian> fendianlist;
	Fendian fendiantemp;

	@Resource
	CangkuService cangkuservice;
	List<Cangku> cangkulist;
	Cangku cangku;

	// 仓库管理首页分店列表
	@RequestMapping("/sylist")
	public String sylist(Model model) {
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("fendianlist", fendianlist);
		return "cangku/sylist";
	}

	// 仓库列表
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, HttpSession session) {
		String fdids = request.getParameter("fdid");
		Integer fdid = 0;
		if (fdids != null) {
			fdid = Integer.valueOf(request.getParameter("fdid"));
			session.setAttribute("fdid", fdid);
		}
		fdid = (Integer) session.getAttribute("fdid");
		cangkulist = cangkuservice.cangkuquery(fdid);
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("cangkulist", cangkulist);
		model.addAttribute("fendianlist", fendianlist);

		return "cangku/list";
	}

	// 新增仓库
	@RequestMapping("/add")
	public String add() {

		return "cangku/add";
	}

	// 执行添加仓库
	@RequestMapping("/doadd")
	public String doadd(Cangku record, Model model, HttpSession session) {
		record.setFdid((Integer) session.getAttribute("fdid"));
		record.setDm(0);
		cangkuservice.cangkuadd(record);
		model.addAttribute("adddate", "仓库添加成功");
		return "redirect:list.action";
	}

	// 修改仓库
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		cangku = cangkuservice.cangkuget(id);
		model.addAttribute("cangku", cangku);
		return "cangku/edit";
	}

	// 执行修改仓库
	@RequestMapping("/doedit")
	public String doedit(Cangku record, Model model) {
		cangkuservice.cangkuupdate(record);
		model.addAttribute("editdate", "修改成功");
		return "redirect:list.action";
	}

	// 删除仓库
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		cangkuservice.cangkudelete(id);
		model.addAttribute("deletedate", "删除成功");
		return "redirect:list.action";
	}
}
