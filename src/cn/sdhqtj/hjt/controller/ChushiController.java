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

import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.entity.Zuzhijigou;
import cn.sdhqtj.hjt.service.ChushiService;

/**
 * 处室controller
 */
@Controller
@RequestMapping("/chushi")
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
	public String list(HttpServletRequest request, Model model) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		login = (Login) session.getAttribute("loginer");
		// 获取分页信息
		int conpage = 1;
		String conpagestr = request.getParameter("conpage");
		if (conpagestr != null) {
			conpage = Integer.valueOf(conpagestr);
		}
		model.addAttribute("conpage", conpage);
		model.addAttribute("count", chushiservice.getcount(login.getFdid()));

		chushilist = chushiservice.getlist(login.getFdid(),  (conpage - 1) * 20);
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
		return "chushi/list";
	}

	/**
	 * 新增处室
	 */
	@RequestMapping("/add")
	public String add() {
		return "chushi/add";
	}

	/**
	 * 执行添加处室
	 */
	@RequestMapping("/doadd")
	public String doadd(Zuzhijigou record, Model model) {
		if (record.getCsbh() == null || record.getCsmc() == null) {
			// 添加失败，处室编号、处室名称不能为空
			model.addAttribute("waymsg", "处室添加失败");
			model.addAttribute("bhmsg", "处室编号不能为空");
			model.addAttribute("mcmsg", "处室名称不能为空");
			model.addAttribute("chushi", record);
			return "chushi/add";
		}

		// 检查重复
		chushilist = chushiservice.checkrepeat(record);
		if (chushilist.size() > 0) {
			// 添加失败，处室编号不能重复
			model.addAttribute("bhmsg", "此处室编号已存在");
			model.addAttribute("waymsg", "处室添加失败");
			model.addAttribute("chushi", record);
			return "chushi/add";
		}

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		Login login = (Login) session.getAttribute("loginer");
		record.setFdid(login.getFdid());
		int res = chushiservice.addchushi(record);
		if (res > 0) {
			// 添加成功
			return "redirect:list?waymsg=add";
		} else {
			// 添加失败
			model.addAttribute("waymsg", "处室添加失败");
			model.addAttribute("chushi", record);
			return "chushi/add";
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
		return "chushi/edit";
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
			return "chushi/edit";
		}

		// 检查重复
		chushilist = chushiservice.checkrepeat(record);
		if (chushilist.size() > 0) {
			// 修改失败，处室编号不能重复
			model.addAttribute("bhmsg", "此科室编号已存在");
			model.addAttribute("waymsg", "处室修改失败");
			model.addAttribute("chushi", record);
			return "chushi/edit";
		}

		int res = chushiservice.updatechushi(record);
		if (res >= 0) {
			// 修改成功
			return "redirect:list?waymsg=edit";
		} else {
			// 修改失败
			model.addAttribute("waymsg", "处室修改失败");
			model.addAttribute("chushi", record);
			return "chushi/edit";
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
	public String search(HttpServletRequest request, Model model) {
		String searchword = request.getParameter("searchword");
		// 获取分页信息
		int conpage = 1;
		String conpagestr = request.getParameter("conpage");
		if (conpagestr != null) {
			conpage = Integer.valueOf(conpagestr);
		}
		model.addAttribute("conpage", conpage);
		model.addAttribute("searchword", searchword);
		
		chushi = new Zuzhijigou();
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		login = (Login) session.getAttribute("loginer");
		chushi.setFdid(login.getFdid());
		chushi.setCsmc(searchword);
		chushilist = chushiservice.searchchushi(chushi,(conpage - 1) * 20);
		model.addAttribute("chushilist", chushilist);
		model.addAttribute("count", chushiservice.getsearchcount(chushi));
		return "chushi/searchlist";
	}

	/**
	 * 下载处室列表Excel
	 */
	@RequestMapping("/downloadexcel")
	public ResponseEntity<byte[]> downloadexcel() throws Exception {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
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
