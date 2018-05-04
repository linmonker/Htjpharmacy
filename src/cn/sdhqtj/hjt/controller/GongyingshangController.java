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

import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;
import cn.sdhqtj.hjt.entity.Login;
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
	
	Login login;

	/**
	 * 供应商列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model, HttpSession session) {
		login = (Login) session.getAttribute("loginer");
		gyslist = gysservice.getquerybyfdid(login.getFdid());
		model.addAttribute("gyslist", gyslist);

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("waymsg", "供应商添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("waymsg", "供应商修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("waymsg", "供应商删除成功");
		} else if ("error".equals(waymsg)) {
			model.addAttribute("waymsg", "操作失误");
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
	public String doadd(GongyingshangWithBLOBs record, Model model, HttpSession session) {
		if (record.getGysbh() == null || record.getGysmc() == null) {
			// 添加失败，供应商编号不能为空
			model.addAttribute("waymsg", "供应商添加失败");
			model.addAttribute("bhmsg", "供应商编号不能为空");
			model.addAttribute("mcmsg", "供应商名称不能为空");
			model.addAttribute("gys", record);
			return "gongyingshang/add";
		}

		// 检查重复
		gyslist = gysservice.checkrepeat(record);
		if (gyslist.size() > 0) {
			// 添加失败，供应商编号不能重复
			model.addAttribute("bhmsg", "此供应商编号已存在");
			model.addAttribute("waymsg", "供应商添加失败");
			model.addAttribute("gys", record);
			return "gongyingshang/add";
		}

		login = (Login) session.getAttribute("loginer");
		record.setFdid(login.getFdid());
		// 尝试添加
		int res = gysservice.addgongyingshang(record);
		if (res > 0) {
			// 添加成功
			return "redirect:list?waymsg=add";
		} else {
			// 添加失败
			model.addAttribute("waymsg", "供应商添加失败");
			model.addAttribute("gys", record);
			return "gongyingshang/add";
		}
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
			model.addAttribute("waymsg", "供应商修改失败");
			model.addAttribute("bhmsg", "供应商编号不能为空");
			model.addAttribute("mcmsg", "供应商名称不能为空");
			model.addAttribute("gys", record);
			return "gongyingshang/edit";
		}

		// 检查重复
		gyslist = gysservice.checkrepeat(record);
		if (gyslist.size() > 0) {
			// 修改失败，供应商编号不能重复
			model.addAttribute("bhmsg", "此供应商编号已存在");
			model.addAttribute("waymsg", "供应商修改失败");
			model.addAttribute("gys", record);
			return "gongyingshang/edit";
		}

		// 尝试修改
		int res = gysservice.updategongyingshang(record);
		if (res >= 0) {
			// 修改成功
			return "redirect:list?waymsg=edit";
		} else {
			// 修改失败
			model.addAttribute("waymsg", "供应商修改失败");
			model.addAttribute("gys", record);
			return "gongyingshang/edit";
		}
	}

	/**
	 * 删除供应商
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		// 尝试删除
		int res = gysservice.deletegongyingshang(Integer.valueOf(request.getParameter("id")));
		if (res > 0) {
			// 删除成功
			return "redirect:list?waymsg=delete";
		} else {
			// 删除失败
			return "redirect:list?waymsg=error";
		}
	}

	/**
	 * 搜索供应商
	 */
	@RequestMapping("/search")
	public String search(String searchword, Model model, HttpSession session) {
		gys = new Gongyingshang();
		login = (Login) session.getAttribute("loginer");
		gys.setFdid(login.getFdid());
		gys.setGysbh(searchword);
		gys.setGysmc(searchword);
		gyslist = gysservice.searchgongyingshang(gys);
		model.addAttribute("gyslist", gyslist);
		return "gongyingshang/list";
	}

	/**
	 * 下载供应商列表Excel
	 */
	@RequestMapping("/downloadexcel")
	public ResponseEntity<byte[]> downloadexcel(HttpSession session) throws Exception {
		login = (Login) session.getAttribute("loginer");
		String path = gysservice.writeexcel(login.getFdid());
		File file = new File(path);
		String fileName = new String("供应商列表.xlsx".getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

}
