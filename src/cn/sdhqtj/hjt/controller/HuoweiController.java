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
import cn.sdhqtj.hjt.entity.Huowei;
import cn.sdhqtj.hjt.service.CangkuService;
import cn.sdhqtj.hjt.service.HuoweiService;

/**
 * 货位controller
 */
@Controller
@RequestMapping("/huowei")
public class HuoweiController {

	@Resource
	HuoweiService huoweiservice;
	List<Huowei> huoweilist;
	Huowei huowei;

	@Resource
	CangkuService cangkuservice;
	Cangku cangku;

	/**
	 * 货位列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		String ckidstr = request.getParameter("ckid");
		if (ckidstr == null) {
			// 仓库id为空，返回仓库列表首页
			return "redirect:/Htjpharmacy/cangku/sylist?waymsg=error";
		}
		int ckid = Integer.valueOf(ckidstr);

		// 获取分页信息
		int conpage = 1;
		String conpagestr = request.getParameter("conpage");
		if (conpagestr != null) {
			conpage = Integer.valueOf(conpagestr);
		}
		model.addAttribute("conpage", conpage);
		model.addAttribute("count", cangkuservice.getcount(ckid));

		huoweilist = huoweiservice.getlist(ckid, (conpage - 1) * 20);
		if (huoweilist.size() < 1) {
			// 货位列表为空，添加一个货位传递分店id、仓库id
			huowei = new Huowei();
			huowei.setCkid(ckid);
			huoweilist.add(huowei);
		}
		model.addAttribute("huoweilist", huoweilist);

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("waymsg", "货位添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("waymsg", "货位修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("waymsg", "货位删除成功");
		} else if ("error".equals(waymsg)) {
			model.addAttribute("waymsg", "操作失误");
		}

		return "huowei/list";
	}

	/**
	 * 新增货位
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		String ckidstr = request.getParameter("ckid");
		if (ckidstr == null) {
			// 仓库id为空，返回仓库列表首页
			return "redirect:/Htjpharmacy/cangku/sylist?waymsg=error";
		}
		int ckid = Integer.valueOf(ckidstr);

		huowei = new Huowei();
		huowei.setCkid(ckid);
		model.addAttribute("huowei", huowei);

		return "huowei/add";
	}

	/**
	 * 执行添加货位
	 */
	@RequestMapping("/doadd")
	public String doadd(Huowei record, Model model) {
		if (record.getHwbh() == null || record.getHwmc() == null) {
			// 添加失败，货位编号、货位名称不能为空
			model.addAttribute("waymsg", "货位添加失败");
			model.addAttribute("bhmsg", "货位编号不能为空");
			model.addAttribute("mcmsg", "货位名称不能为空");
			model.addAttribute("huowei", record);
			return "huowei/add";
		}

		// 检查重复
		huoweilist = huoweiservice.checkrepeat(record);
		if (huoweilist.size() > 0) {
			// 添加失败，货位编号不能重复
			model.addAttribute("bhmsg", "此货位编号已存在");
			model.addAttribute("waymsg", "货位添加失败");
			model.addAttribute("huowei", record);
			return "huowei/add";
		}

		// 从数据库获取fdid
		cangku = cangkuservice.getcangku(record.getCkid());
		int fdid = cangku.getFdid();
		record.setFdid(fdid);

		int res = huoweiservice.addhuowei(record);
		if (res > 0) {
			// 添加成功
			return "redirect:list?waymsg=add&&ckid=" + record.getCkid();
		} else {
			// 添加失败
			model.addAttribute("waymsg", "货位添加失败");
			model.addAttribute("huowei", record);
			return "huowei/add";
		}
	}

	/**
	 * 修改货位
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		int ckid = Integer.valueOf(request.getParameter("ckid"));
		huowei = huoweiservice.gethuowei(ckid);
		model.addAttribute("huowei", huowei);
		return "huowei/edit";
	}

	/**
	 * 执行修改货位
	 */
	@RequestMapping("/doedit")
	public String doedit(Huowei record, Model model) {
		if (record.getHwbh() == null || record.getHwmc() == null) {
			// 修改失败，货位编号、货位名称不能为空
			model.addAttribute("waymsg", "货位修改失败");
			model.addAttribute("bhmsg", "货位编号不能为空");
			model.addAttribute("mcmsg", "货位名称不能为空");
			model.addAttribute("huowei", record);
			return "huowei/edit";
		}

		// 检查重复
		huoweilist = huoweiservice.checkrepeat(record);
		if (huoweilist.size() > 0) {
			// 修改失败，货位编号不能重复
			model.addAttribute("bhmsg", "此货位编号已存在");
			model.addAttribute("waymsg", "货位修改失败");
			model.addAttribute("huowei", record);
			return "huowei/edit";
		}

		int res = huoweiservice.addhuowei(record);
		if (res >= 0) {
			// 修改成功
			return "redirect:list?waymsg=edit&&ckid=" + record.getCkid();
		} else {
			// 修改失败
			model.addAttribute("waymsg", "货位修改失败");
			model.addAttribute("huowei", record);
			return "huowei/edit";
		}
	}

	/**
	 * 删除货位
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		int id = Integer.valueOf(request.getParameter("id"));
		String ckid = request.getParameter("ckid");

		int res = huoweiservice.deletehuowei(id);
		if (res > 0) {
			// 删除成功
			return "redirect:list?waymsg=delete&&ckid=" + ckid;
		} else {
			// 删除失败
			return "redirect:list?waymsg=error&&ckid=" + ckid;
		}
	}

	/**
	 * 搜索货位
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		String ckidstr = request.getParameter("ckid");
		if (ckidstr == null) {
			// 仓库id为空，返回仓库列表首页
			return "redirect:/Htjpharmacy/cangku/sylist?waymsg=error";
		}
		int ckid = Integer.valueOf(ckidstr);

		String searchword = request.getParameter("searchword");
		// 获取分页信息
		int conpage = 1;
		String conpagestr = request.getParameter("conpage");
		if (conpagestr != null) {
			conpage = Integer.valueOf(conpagestr);
		}
		model.addAttribute("conpage", conpage);
		model.addAttribute("searchword", searchword);

		huowei = new Huowei();
		huowei.setCkid(ckid);
		huowei.setHwmc(searchword);
		huoweilist = huoweiservice.searchhuowei(huowei, (conpage - 1) * 20);
		model.addAttribute("huoweilist", huoweilist);
		model.addAttribute("count", huoweiservice.getsearchcount(huowei));

		return "huowei/searchlist";
	}

	/**
	 * 下载货位列表Excel
	 */
	@RequestMapping("/downloadexcel")
	public ResponseEntity<byte[]> downloadexcel(HttpServletRequest request) throws Exception {
		int ckid = Integer.valueOf(request.getParameter("ckid"));
		String path = huoweiservice.writeexcel(ckid);
		File file = new File(path);
		String fileName = new String("货位列表.xlsx".getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

}
