package cn.sdhqtj.hjt.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.Cangku;
import cn.sdhqtj.hjt.entity.Fendian;
import cn.sdhqtj.hjt.service.CangkuService;
import cn.sdhqtj.hjt.service.FendianService;

/**
 * 仓库controller
 */
@Controller
@RequestMapping("/cangku")
public class CangkuController {

	@Resource
	CangkuService cangkuservice;
	List<Cangku> cangkulist;
	Cangku cangku;

	@Resource
	FendianService fendianservice;
	List<Fendian> fendianlist;
	Fendian fendian;

	/**
	 * 仓库管理首页分店列表
	 */
	@RequestMapping("/sylist")
	public String sylist(HttpServletRequest request, Model model) {
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("fendianlist", fendianlist);
		String waymsg = request.getParameter("waymsg");
		if ("error".equals(waymsg)) {
			model.addAttribute("waymsg", "操作失误");
		}
		return "cangku/sylist";
	}

	/**
	 * 仓库列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		String fdidstr = request.getParameter("fdid");
		if (fdidstr == null) {
			// 分店id获取失败，返回仓库列表首页
			return "redirect:sylist?waymsg=error";
		}
		int fdid = Integer.valueOf(fdidstr);

		// 获取分页信息
		int conpage = 1;
		String conpagestr = request.getParameter("conpage");
		if (conpagestr != null) {
			conpage = Integer.valueOf(conpagestr);
		}
		model.addAttribute("conpage", conpage);
		model.addAttribute("count", cangkuservice.getcount(fdid));

		cangkulist = cangkuservice.getlist(fdid, (conpage - 1) * 20);
		if (cangkulist.size() < 1) {
			// 仓库列表为空，添加一个仓库传递分店id
			cangku = new Cangku();
			cangku.setFdid(fdid);
			cangkulist.add(cangku);
		}
		model.addAttribute("cangkulist", cangkulist);
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("fendianlist", fendianlist);

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("waymsg", "仓库添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("waymsg", "仓库修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("waymsg", "仓库删除成功");
		} else if ("error".equals(waymsg)) {
			model.addAttribute("waymsg", "操作失误");
		}
		return "cangku/list";

	}

	/**
	 * 新增仓库
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		String fdidstr = request.getParameter("fdid");
		if (fdidstr == null) {
			// 分店id获取失败，返回仓库列表首页
			return "redirect:sylist?waymsg=error";
		}
		int fdid = Integer.valueOf(fdidstr);

		// 添加一个仓库传递分店id
		cangku = new Cangku();
		cangku.setFdid(fdid);
		model.addAttribute("cangku", cangku);
		return "cangku/add";
	}

	/**
	 * 执行添加仓库
	 */
	@RequestMapping("/doadd")
	public String doadd(HttpServletRequest request, Cangku record, Model model) {
		if (record.getCkbh() == null || record.getCkmc() == null) {
			// 添加失败，仓库编号、仓库名称不能为空
			model.addAttribute("waymsg", "仓库添加失败");
			model.addAttribute("bhmsg", "仓库编号不能为空");
			model.addAttribute("mcmsg", "仓库名称不能为空");
			model.addAttribute("cangku", record);
			return "cangku/add";
		}

		// 检查重复
		cangkulist = cangkuservice.checkrepeat(record);
		if (cangkulist.size() > 0) {
			// 添加失败，仓库编号不能重复
			model.addAttribute("bhmsg", "此仓库编号已存在");
			model.addAttribute("waymsg", "仓库添加失败");
			model.addAttribute("cangku", record);
			return "cangku/add";
		}

		// 尝试添加
		int res = cangkuservice.addcangku(record);
		if (res > 0) {
			// 添加成功
			return "redirect:list?waymsg=add&&fdid=" + record.getFdid();
		} else {
			// 添加失败
			model.addAttribute("waymsg", "仓库添加失败");
			model.addAttribute("cangku", record);
			return "cangku/add";
		}
	}

	/**
	 * 修改仓库
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		cangku = cangkuservice.getcangku(id);
		model.addAttribute("cangku", cangku);
		return "cangku/edit";
	}

	/**
	 * 执行修改仓库
	 */
	@RequestMapping("/doedit")
	public String doedit(Cangku record, Model model) {
		if (record.getCkbh() == null || record.getCkmc() == null) {
			// 修改失败，仓库编号、仓库名称不能为空
			model.addAttribute("waymsg", "仓库修改失败");
			model.addAttribute("bhmsg", "仓库编号不能为空");
			model.addAttribute("mcmsg", "仓库名称不能为空");
			model.addAttribute("cangku", record);
			return "cangku/edit";
		}

		// 检查重复
		cangkulist = cangkuservice.checkrepeat(record);
		if (cangkulist.size() > 0) {
			// 修改失败，仓库编号不能重复
			model.addAttribute("bhmsg", "此仓库编号已存在");
			model.addAttribute("waymsg", "仓库修改失败");
			model.addAttribute("cangku", record);
			return "cangku/edit";
		}

		int res = cangkuservice.updatecangku(record);
		if (res >= 0) {
			// 修改成功
			return "redirect:list?waymsg=edit&&fdid=" + record.getFdid();
		} else {
			// 修改失败
			model.addAttribute("cangku", record);
			return "cangku/edit";
		}
	}

	/**
	 * 删除仓库
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		String fdid = request.getParameter("fdid");

		int res = cangkuservice.deletecangku(id);
		if (res > 0) {
			// 删除成功
			return "redirect:list?waymsg=delete&&fdid=" + fdid;
		} else {
			// 删除失败
			return "redirect:list?waymsg=error&&fdid=" + fdid;
		}
	}

	/**
	 * 搜索仓库
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		String fdidstr = request.getParameter("fdid");
		if (fdidstr == null) {
			// 分店id获取失败，返回仓库列表首页
			return "redirect:sylist?waymsg=error";
		}
		int fdid = Integer.valueOf(fdidstr);

		String searchword = request.getParameter("searchword");
		// 获取分页信息
		int conpage = 1;
		String conpagestr = request.getParameter("conpage");
		if (conpagestr != null) {
			conpage = Integer.valueOf(conpagestr);
		}
		model.addAttribute("conpage", conpage);
		model.addAttribute("searchword", searchword);

		cangku = new Cangku();
		cangku.setFdid(fdid);
		cangku.setCkmc(searchword);
		cangkulist = cangkuservice.searchcangku(cangku, (conpage - 1) * 20);
		model.addAttribute("cangkulist", cangkulist);
		model.addAttribute("count", cangkuservice.getsearchcount(cangku));
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("fendianlist", fendianlist);

		return "cangku/searchlist";
	}

	/**
	 * 下载供应商列表Excel
	 */
	@RequestMapping("/downloadexcel")
	public ResponseEntity<byte[]> downloadexcel(HttpServletRequest request) throws Exception {
		int fdid = Integer.valueOf(request.getParameter("fdid"));
		String path = cangkuservice.writeexcel(fdid);
		File file = new File(path);
		String fileName = new String("仓库列表.xlsx".getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
}
