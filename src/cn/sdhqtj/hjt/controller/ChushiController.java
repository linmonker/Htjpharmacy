package cn.sdhqtj.hjt.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	 * 处室列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, HttpSession session) {
		login = (Login) session.getAttribute("loginer");
		chushilist = chushiservice.chushiquery(login.getFdid());
		model.addAttribute("chushilist", chushilist);

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("waymsg", "处室添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("waymsg", "处室修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("waymsg", "处室删除成功");
		} else if ("error".equals(waymsg)) {
			model.addAttribute("waymsg", "操作失误");
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
			model.addAttribute("waymsg", "处室添加失败");
			model.addAttribute("bhmsg", "处室编号不能为空");
			model.addAttribute("mcmsg", "处室名称不能为空");
			model.addAttribute("chushi", record);
			return "zuzhijigou/add";
		}

		// 检查重复
		chushilist = chushiservice.checkrepeat(record);
		if (chushilist.size() > 0) {
			// 添加失败，处室编号不能重复
			model.addAttribute("bhmsg", "此处室编号已存在");
			model.addAttribute("waymsg", "处室添加失败");
			model.addAttribute("chushi", record);
			return "zuzhijigou/add";
		}

		Login login=(Login) session.getAttribute("loginer");
		record.setFdid(login.getFdid());
		int res = chushiservice.addchushi(record);
		if (res > 0) {
			// 添加成功
			return "redirect:list?waymsg=add";
		} else {
			// 添加失败
			model.addAttribute("waymsg", "处室添加失败");
			model.addAttribute("chushi", record);
			return "zuzhijigou/add";
		}
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
			model.addAttribute("waymsg", "处室修改失败");
			model.addAttribute("bhmsg", "处室编号不能为空");
			model.addAttribute("mcmsg", "处室名称不能为空");
			model.addAttribute("chushi", record);
			return "zuzhijigou/edit";
		}

		// 检查重复
		chushilist = chushiservice.checkrepeat(record);
		if (chushilist.size() > 0) {
			// 修改失败，处室编号不能重复
			model.addAttribute("bhmsg", "此科室编号已存在");
			model.addAttribute("waymsg", "处室修改失败");
			model.addAttribute("chushi", record);
			return "zuzhijigou/edit";
		}

		int res = chushiservice.updatechushi(record);
		if (res >= 0) {
			// 修改成功
			return "redirect:list?waymsg=edit";
		} else {
			// 修改失败
			model.addAttribute("waymsg", "处室修改失败");
			model.addAttribute("chushi", record);
			return "zuzhijigou/edit";
		}
	}

	/**
	 * 删除处室
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		int res = chushiservice.deletechushi(id);
		if (res > 0) {
			// 删除成功
			return "redirect:list?waymsg=delete";
		} else {
			// 删除失败
			return "redirect:list?waymsg=error";
		}
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
	
	/**
	 * 下载处室列表Excel
	 */
	@RequestMapping("/downloadexcel")
	public ResponseEntity<byte[]> downloadexcel(HttpSession session) throws Exception {
		login = (Login) session.getAttribute("loginer");
		String path = chushiservice.writeexcel(login.getFdid());
		File file = new File(path);
		String fileName = new String("处室列表.xlsx".getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
}
