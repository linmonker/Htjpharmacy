package cn.sdhqtj.hjt.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sdhqtj.hjt.entity.GongyingshangVo;
import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinVo;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;
import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.service.GongyingshangService;
import cn.sdhqtj.hjt.service.YaopinService;
import cn.sdhqtj.hjt.service.YaopinfenleiService;

/**
 * 药品controller
 */
@Controller
@RequestMapping("/yaopin")
public class YaopinController {

	@Resource
	YaopinService yaopinservice;
	List<YaopinVo> yaopinvolist;
	Yaopin yaopin;
	List<Yaopin> yaopinlist;
	YaopinWithBLOBs yaopinB;

	@Resource
	YaopinfenleiService ypflservice;
	List<Yaopinfenlei> ypfllist;

	@Resource
	GongyingshangService gysservice;
	List<GongyingshangVo> gysVlist;

	/**
	 * 药品列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		// 获取分页信息
		int conpage = 1;
		String conpagestr = request.getParameter("conpage");
		if (conpagestr != null) {
			conpage = Integer.valueOf(conpagestr);
		}
		model.addAttribute("conpage", conpage);
		model.addAttribute("count", yaopinservice.getcount());

		yaopinvolist = yaopinservice.getlist((conpage-1)*20);
		model.addAttribute("yaopinlist", yaopinvolist);

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("waymsg", "药品添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("waymsg", "药品修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("waymsg", "药品删除成功");
		} else if ("error".equals(waymsg)) {
			model.addAttribute("waymsg", "操作失误");
		}
		return "yaopin/list";
	}

	/**
	 * 新增药品
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		ypfllist = ypflservice.Yaopinfenleiquery();
		gysVlist = gysservice.gongyingshanAllgquery();
		model.addAttribute("ypfllist", ypfllist);
		model.addAttribute("gyslist", gysVlist);
		return "yaopin/add";
	}

	/**
	 * 执行添加药品
	 */
	@RequestMapping("/doadd")
	public String doadd(YaopinWithBLOBs record, Model model) {
		if (record.getYpbh() == null || record.getYpspm() == null) {
			// 添加失败，药品编号、药品名称不能为空
			model.addAttribute("waymsg", "药品添加失败");
			model.addAttribute("bhmsg", "药品编号不能为空");
			model.addAttribute("mcmsg", "药品名称不能为空");
			model.addAttribute("yaopin", record);

			ypfllist = ypflservice.Yaopinfenleiquery();
			gysVlist = gysservice.gongyingshanAllgquery();
			model.addAttribute("ypfllist", ypfllist);
			model.addAttribute("gyslist", gysVlist);

			return "yaopin/add";
		}

		// 检查重复
		yaopinlist = yaopinservice.checkrepeat(record);
		if (yaopinlist.size() > 0) {
			// 添加失败,药品编号不能重复
			model.addAttribute("bhmsg", "此药品编号已存在");
			model.addAttribute("waymsg", "药品添加失败");
			model.addAttribute("yaopin", record);

			ypfllist = ypflservice.Yaopinfenleiquery();
			gysVlist = gysservice.gongyingshanAllgquery();
			model.addAttribute("ypfllist", ypfllist);
			model.addAttribute("gyslist", gysVlist);

			return "yaopin/add";
		}
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		Login loginer = (Login) session.getAttribute("loginer");
		record.setYpcjr(loginer.getId());

		int res = yaopinservice.addyaopin(record);
		if (res > 0) {
			// 添加成功
			return "redirect:list?waymsg=add";
		} else {
			// 添加失败
			model.addAttribute("waymsg", "药品添加失败");
			model.addAttribute("yaopin", record);

			ypfllist = ypflservice.Yaopinfenleiquery();
			gysVlist = gysservice.gongyingshanAllgquery();
			model.addAttribute("ypfllist", ypfllist);
			model.addAttribute("gyslist", gysVlist);

			return "yaopin/add";
		}
	}

	/**
	 * 修改药品
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		yaopinB = yaopinservice.getyaopin(Integer.valueOf(request.getParameter("id")));
		model.addAttribute("yaopin", yaopinB);

		ypfllist = ypflservice.Yaopinfenleiquery();
		gysVlist = gysservice.gongyingshanAllgquery();
		model.addAttribute("ypfllist", ypfllist);
		model.addAttribute("gyslist", gysVlist);

		return "yaopin/edit";
	}

	/**
	 * 执行修改药品
	 */
	@RequestMapping("/doedit")
	public String doedit(YaopinWithBLOBs record, Model model) {
		if (record.getYpbh() == null || record.getYpspm() == null) {
			// 修改失败，药品编号、药品名称不能为空
			model.addAttribute("waymsg", "药品修改失败");
			model.addAttribute("bhmsg", "药品编号不能为空");
			model.addAttribute("mcmsg", "药品名称不能为空");
			model.addAttribute("yaopin", record);

			ypfllist = ypflservice.Yaopinfenleiquery();
			gysVlist = gysservice.gongyingshanAllgquery();
			model.addAttribute("ypfllist", ypfllist);
			model.addAttribute("gyslist", gysVlist);

			return "yaopin/edit";
		}

		// 检查重复
		yaopinlist = yaopinservice.checkrepeat(record);
		if (yaopinlist.size() > 0) {
			// 修改失败，药品编号不能重复
			model.addAttribute("bhmsg", "此药品编号已存在");
			model.addAttribute("waymsg", "药品修改失败");
			model.addAttribute("yaopin", record);

			ypfllist = ypflservice.Yaopinfenleiquery();
			gysVlist = gysservice.gongyingshanAllgquery();
			model.addAttribute("ypfllist", ypfllist);
			model.addAttribute("gyslist", gysVlist);

			return "yaopin/edit";
		}

		int res = yaopinservice.updateyaopin(record);
		if (res >= 0) {
			// 修改成功
			return "redirect:list?waymsg=edit";
		} else {
			// 修改失败
			model.addAttribute("waymsg", "药品修改失败");
			model.addAttribute("yaopin", record);

			ypfllist = ypflservice.Yaopinfenleiquery();
			gysVlist = gysservice.gongyingshanAllgquery();
			model.addAttribute("ypfllist", ypfllist);
			model.addAttribute("gyslist", gysVlist);

			return "yaopin/edit";
		}
	}

	/**
	 * 删除药品
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String idstr = request.getParameter("id");
		int res = yaopinservice.deleteyaopin(Integer.valueOf(idstr));
		if (res > 0) {
			// 删除成功
			return "redirect:list?waymsg=delete";
		} else {
			// 删除失败
			return "redirect:list?waymsg=error";
		}
	}

	/**
	 * 搜索药品
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request,Model model) {
		String searchword = request.getParameter("searchword");
		// 获取分页信息
		int conpage = 1;
		String conpagestr = request.getParameter("conpage");
		if (conpagestr != null) {
			conpage = Integer.valueOf(conpagestr);
		}
		model.addAttribute("conpage", conpage);
		model.addAttribute("searchword", searchword);

		yaopin = new Yaopin();
		yaopin.setYpspm(searchword);
		yaopinvolist = yaopinservice.searchyaopin(yaopin, (conpage - 1) * 20);
		model.addAttribute("yaopinlist", yaopinvolist);
		model.addAttribute("count", yaopinservice.getsearchcount(yaopin));
		return "yaopin/searchlist";
	}

	/**
	 * 下载药品列表Excel
	 */
	@RequestMapping("/downloadexcel")
	public ResponseEntity<byte[]> downloadexcel() throws Exception {
		String path = yaopinservice.writeexcel();
		File file = new File(path);
		String fileName = new String("药品列表.xlsx".getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

}
