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

import cn.sdhqtj.hjt.entity.Keshi;
import cn.sdhqtj.hjt.service.KeshiService;
import cn.sdhqtj.hjt.entity.Login;

/**
 * 科室controller
 */
@Controller
@RequestMapping("/keshi")
public class KeshiController {

	@Resource
	KeshiService keshiservice;
	List<Keshi> keshilist;
	Keshi keshi;

	Login login;

	/**
	 * 科室列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, HttpSession session) {

		login = (Login) session.getAttribute("loginer");
		keshilist = keshiservice.keshiquery(login.getFdid());
		model.addAttribute("keshilist", keshilist);

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("waymsg", "科室添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("waymsg", "科室修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("waymsg", "科室删除成功");
		} else if ("error".equals(waymsg)) {
			model.addAttribute("waymsg", "操作失误");
		}
		return "keshi/list";
	}

	/**
	 * 新增科室
	 */
	@RequestMapping("/add")
	public String add() {
		return "keshi/add";
	}

	/**
	 * 执行添加科室
	 */
	@RequestMapping("/doadd")
	public String doadd(Keshi record, Model model, HttpSession session) {
		if (record.getKsbh() == null || record.getKsmc() == null) {
			// 添加失败，科室编号、科室名称不能为空
			model.addAttribute("waymsg", "科室添加失败");
			model.addAttribute("bhmsg", "科室编号不能为空");
			model.addAttribute("mcmsg", "科室名称不能为空");
			model.addAttribute("keshi", record);
			return "keshi/add";
		}

		// 检查重复
		keshilist = keshiservice.checkrepeat(record);
		if (keshilist.size() > 0) {
			// 添加失败，科室编号不能重复
			model.addAttribute("bhmsg", "此科室编号已存在");
			model.addAttribute("waymsg", "科室添加失败");
			model.addAttribute("keshi", record);
			return "keshi/add";
		}

		Login login = (Login) session.getAttribute("loginer");
		record.setFdid(login.getFdid());
		int res = keshiservice.addkeshi(record);
		if (res > 0) {
			// 添加成功
			return "redirect:list?waymsg=add";
		} else {
			// 添加失败
			model.addAttribute("waymsg", "科室添加失败");
			model.addAttribute("keshi", record);
			return "keshi/add";
		}
	}

	/**
	 * 修改科室
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		keshi = keshiservice.getkeshi(id);
		model.addAttribute("keshi", keshi);
		return "keshi/edit";
	}

	/**
	 * 执行修改科室
	 */
	@RequestMapping("/doedit")
	public String doedit(Keshi record, Model model) {
		if (record.getKsbh() == null || record.getKsmc() == null) {
			// 修改失败，科室编号、科室名称不能为空
			model.addAttribute("waymsg", "科室修改失败");
			model.addAttribute("bhmsg", "科室编号不能为空");
			model.addAttribute("mcmsg", "科室名称不能为空");
			model.addAttribute("keshi", record);
			return "keshi/edit";
		}

		// 检查重复
		keshilist = keshiservice.checkrepeat(record);
		if (keshilist.size() > 0) {
			// 科室编号不能重复
			model.addAttribute("bhmsg", "此科室编号已存在");
			model.addAttribute("waymsg", "科室修改失败");
			model.addAttribute("keshi", record);
			return "keshi/edit";
		}

		int res = keshiservice.updatekeshi(keshi);
		if (res >= 0) {
			// 修改成功
			return "redirect:list?waymsg=edit";
		} else {
			// 修改失败
			model.addAttribute("waymsg", "科室修改失败");
			model.addAttribute("keshi", record);
			return "keshi/edit";
		}
	}

	/**
	 * 删除科室
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		int id = Integer.valueOf(request.getParameter("id"));
		int res = keshiservice.deletekeshi(id);
		if (res > 0) {
			// 修改成功
			return "redirect:list?waymsg=delete";
		} else {
			// 修改失败
			return "redirect:list?waymsg=error";
		}
	}

	/**
	 * 搜索科室
	 */
	@RequestMapping("/search")
	public String search(String searchword, Model model, HttpSession session) {
		keshi = new Keshi();
		login = (Login) session.getAttribute("loginer");
		keshi.setFdid(login.getFdid());
		keshi.setKsmc(searchword);
		keshilist = keshiservice.searchkeshi(keshi);
		model.addAttribute("keshilist", keshilist);
		return "keshi/list";
	}
	
	/**
	 * 下载科室列表Excel
	 */
	@RequestMapping("/downloadexcel")
	public ResponseEntity<byte[]> downloadexcel(HttpSession session) throws Exception {
		login = (Login) session.getAttribute("loginer");
		String path = keshiservice.writeexcel(login.getFdid());
		File file = new File(path);
		String fileName = new String("科室列表.xlsx".getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
	
}
