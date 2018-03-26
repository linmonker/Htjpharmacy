package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Fendian;
import cn.sdhqtj.hjt.service.FendianService;

/**
 * 分店controller
 */
@Controller
@RequestMapping("/fendian")
public class FendianController {

	@Resource
	FendianService fendianservice;
	Fendian fendian;
	List<Fendian> fendianlist;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("fendianlist", fendianlist);

		String data = request.getParameter("adddata");
		if (data != null) {
			model.addAttribute("adddata", "分店添加成功");
		}
		data = request.getParameter("editdata");
		if (data != null) {
			model.addAttribute("editdata", "分店修改成功");
		}
		data = request.getParameter("deletedata");
		if (data != null) {
			model.addAttribute("deletedata", "分店删除成功");
		}
		return "fendian/list";
	}

	/**
	 * 添加分店
	 */
	@RequestMapping("/add")
	public String add() {

		return "fendian/add";
	}

	/**
	 * 执行添加分店
	 */
	@RequestMapping("/doadd")
	public String doadd(Fendian record, Model model) {
		fendianlist = fendianservice.checkrepeat(record);

		if (record.getFdbh() == null || record.getFdmc() == null || fendianlist.size() > 0) {
			// 添加失败
			for (Fendian temp : fendianlist) {
				if (temp.getFdbh() != null) {
					model.addAttribute("bhdata", "此分店编号已存在");
				}
				if (temp.getFdmc() != null) {
					model.addAttribute("mcdata", "此分店名称已存在");
				}
			}
			model.addAttribute("adddata", "分店添加失败");
			model.addAttribute("fendian", record);
			return "fendian/add";
		} else {// 添加成功
			fendianservice.fendianadd(record);
			return "redirect:list.action?adddata=1";
		}
	}

	/**
	 * 修改分店
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		fendian = fendianservice.fendianget(Integer.valueOf(request.getParameter("id")));
		model.addAttribute("fendian", fendian);
		return "fendian/edit";
	}

	/**
	 * 执行修改分店
	 */
	@RequestMapping("/doedit")
	public String doedit(Fendian record, Model model) {
		fendianlist = fendianservice.checkrepeat(record);

		if (record.getFdbh() == null || record.getFdmc() == null || fendianlist.size() > 0) {
			// 修改失败
			for (Fendian temp : fendianlist) {
				if (temp.getFdbh() != null) {
					model.addAttribute("bhdata", "此分店编号已存在");
				}
				if (temp.getFdmc() != null) {
					model.addAttribute("mcdata", "此分店名称已存在");
				}
			}
			model.addAttribute("editdata", "分店修改失败");
			model.addAttribute("fendian", record);
			return "fendian/edit";
		} else {// 修改成功
			fendianservice.fendianupdate(record);
			return "redirect:list.action?editdata=1";
		}
	}

	/**
	 * 删除分店
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		fendianservice.fendiandelete(Integer.valueOf(request.getParameter("id")));
		return "redirect:list.action?deleta=1";
	}
}
