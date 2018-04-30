package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.entity.Zuzhijigou;
import cn.sdhqtj.hjt.service.ChushiService;

/**
 * 处室controller
 */
@Controller
@RequestMapping("/zuzhijigou")
public class ChushiController {

	@Resource
	ChushiService chushiservice;
	List<Zuzhijigou> chushilist;
	Zuzhijigou chushi;

	Login login;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, HttpSession session) {
		login = (Login) session.getAttribute("loginer");
		chushilist = chushiservice.chushiquery(login.getFdid());
		model.addAttribute("chushilist", chushilist);

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("addmsg", "处室添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "处室修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "处室删除成功");
		}
		return "zuzhijigou/list";
	}

	/**
	 * 新增处室
	 */
	@RequestMapping("/add")
	public String add() {
		return "zuzhijigou/add";
	}

	/**
	 * 执行添加处室
	 */
	@RequestMapping("/doadd")
	public String doadd(Zuzhijigou record, Model model, HttpSession session) {
		if (record.getCsbh() == null || record.getCsmc() == null) {
			// 添加失败，处室编号、处室名称不能为空
			model.addAttribute("addmsg", "处室添加失败");
			model.addAttribute("bhmsg", "处室编号不能为空");
			model.addAttribute("mcmsg", "处室名称不能为空");
			model.addAttribute("chushi", record);
			return "zuzhijigou/add";
		}
		chushilist = chushiservice.checkrepeat(record);
		if (chushilist.size() > 0) {
			// 添加失败，处室编号不能重复
			model.addAttribute("bhmsg", "此处室编号已存在");
			model.addAttribute("addmsg", "处室添加失败");
			model.addAttribute("chushi", record);
			return "zuzhijigou/add";
		}
		// 添加成功
		chushiservice.addchushi(record);
		return "redirect:list?waymsg=add";
	}

	/**
	 * 修改处室
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		chushi = chushiservice.getchushi(id);
		model.addAttribute("chushi", chushi);
		return "zuzhijigou/edit";
	}

	/**
	 * 执行修改处室
	 */
	@RequestMapping("/doedit")
	public String doedit(Zuzhijigou record, Model model) {
		if (record.getCsbh() == null || record.getCsmc() == null) {
			// 修改失败，处室编号、处室名称不能为空
			model.addAttribute("editmsg", "处室修改失败");
			model.addAttribute("bhmsg", "处室编号不能为空");
			model.addAttribute("mcmsg", "处室名称不能为空");
			model.addAttribute("chushi", record);
			return "zuzhijigou/edit";
		}
		chushi = chushiservice.getchushi(record.getId());
		// 判断处室编号修改
		if (!chushi.getCsbh().equals(record.getCsbh())) {
			chushilist = chushiservice.checkrepeat(record);
			if (chushilist.size() > 0) {
				// 修改失败，处室编号不能重复
				model.addAttribute("bhmsg", "此科室编号已存在");
				model.addAttribute("editmsg", "处室修改失败");
				model.addAttribute("chushi", record);
				return "zuzhijigou/edit";
			}
		}
		// 修改成功
		chushiservice.updatechushi(record);
		return "redirect:list?waymsg=edit";

	}

	/**
	 * 删除处室
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		chushiservice.deletechushi(id);
		return "redirect:list?waymsg=delete";
	}

	/**
	 * 搜索处室
	 */
	@RequestMapping("/search")
	public String search(String searchword, Model model, HttpSession session) {
		chushi = new Zuzhijigou();
		login = (Login) session.getAttribute("loginer");
		chushi.setFdid(login.getFdid());
		chushi.setCsmc(searchword);
		chushilist = chushiservice.searchchushi(chushi);
		model.addAttribute("chushilist", chushilist);
		return "zuzhijigou/list";
	}
}
