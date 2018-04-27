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
	 * 分店列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("fendianlist", fendianlist);

		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("addmsg", "分店添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "分店修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "分店删除成功");
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
					model.addAttribute("bhmsg", "此分店编号已存在");
				}
				if (temp.getFdmc() != null) {
					model.addAttribute("mcmsg", "此分店名称已存在");
				}
			}
			model.addAttribute("addmsg", "分店添加失败");
			model.addAttribute("fendian", record);
			return "fendian/add";
		} else {// 添加成功
			fendianservice.addfendian(record);
			return "redirect:list?waymsg=add";
		}
	}

	/**
	 * 修改分店
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		fendian = fendianservice.getfendian(Integer.valueOf(request.getParameter("id")));
		model.addAttribute("fendian", fendian);
		return "fendian/edit";
	}

	/**
	 * 执行修改分店
	 */
	@RequestMapping("/doedit")
	public String doedit(Fendian record, Model model) {
		fendian = fendianservice.getfendian(record.getId());
		if ((!fendian.getFdbh().equals(record.getFdbh())) || (!fendian.getFdmc().equals(record.getFdmc()))) {
			fendianlist = fendianservice.checkrepeat(record);
			if (record.getFdbh() == null || record.getFdmc() == null || fendianlist.size() > 0) {
				// 修改失败
				for (Fendian temp : fendianlist) {
					if (temp.getFdbh() != null) {
						model.addAttribute("bhmsg", "此分店编号已存在");
					}
					if (temp.getFdmc() != null) {
						model.addAttribute("mcmsg", "此分店名称已存在");
					}
				}
				model.addAttribute("editmsg", "分店修改失败");
				model.addAttribute("fendian", record);
				return "fendian/edit";
			}
		}
		// 修改成功
		fendianservice.updatefendian(record);
		return "redirect:list?waymsg=edit";
	}

	/**
	 * 删除分店
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		fendianservice.deletefendian(Integer.valueOf(request.getParameter("id")));
		return "redirect:list?waymsg=delete";
	}

	/**
	 * 搜索分店
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, String searchword, Model model) {
		fendian = new Fendian();
		fendian.setFdmc(searchword);
		fendianlist = fendianservice.searchfendian(fendian);
		model.addAttribute("fendianlist", fendianlist);
		return "fendian/list";
	}
}
