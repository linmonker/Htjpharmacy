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

import cn.sdhqtj.hjt.entity.Fendian;
import cn.sdhqtj.hjt.entity.Role;
import cn.sdhqtj.hjt.entity.Yonghu;
import cn.sdhqtj.hjt.entity.YonghuVo;
import cn.sdhqtj.hjt.entity.Zuzhijigou;
import cn.sdhqtj.hjt.service.ChushiService;
import cn.sdhqtj.hjt.service.FendianService;
import cn.sdhqtj.hjt.service.RoleService;
import cn.sdhqtj.hjt.service.YonghuService;

/**
 * 用户controller
 */
@Controller
@RequestMapping("/yonghu")
public class YonghuController {

	@Resource
	YonghuService yonghuservice;
	List<Yonghu> yonghulist;
	Yonghu yonghu;
	List<YonghuVo> yhvolist;
	YonghuVo yhvo;

	@Resource
	FendianService fendianservice;
	List<Fendian> fendianlist;
	Fendian fendian;

	@Resource
	RoleService roleservice;
	List<Role> rolelist;
	Role role;

	@Resource
	ChushiService chushiservice;
	List<Zuzhijigou> chushilist;
	Zuzhijigou chushi;

	/**
	 * 用户管理首页分店列表
	 */
	@RequestMapping("/sylist")
	public String sylist(HttpServletRequest request, Model model) {
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("fendianlist", fendianlist);

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("error".equals(waymsg)) {
			model.addAttribute("waymsg", "操作失误");
		}
		return "yonghu/sylist";
	}

	/**
	 * 用户列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		String fdidstr = request.getParameter("fdid");
		if (fdidstr == null) {
			// 分店id获取失败，返回用户列表首页
			return "redirect:sylist";
		}
		int fdid = Integer.valueOf(fdidstr);

		// 获取分页信息
		int conpage = 1;
		String conpagestr = request.getParameter("conpage");
		if (conpagestr != null) {
			conpage = Integer.valueOf(conpagestr);
		}
		model.addAttribute("conpage", conpage);
		model.addAttribute("count", yonghuservice.getcount(fdid));

		yhvolist = yonghuservice.getlist(fdid, (conpage - 1) * 20);
		if (yhvolist.size() < 1) {
			// 用户列表为空，添加一个用户传递分店id
			yhvo = new YonghuVo();
			yhvo.setFdid(fdid);
			yhvolist.add(yhvo);
		}
		model.addAttribute("yonghulist", yhvolist);
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("fendianlist", fendianlist);

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("waymsg", "用户添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("waymsg", "用户修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("waymsg", "用户删除成功");
		} else if ("error".equals(waymsg)) {
			model.addAttribute("waymsg", "操作失误");
		}
		return "yonghu/list";
	}

	/**
	 * 新增用户
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		String fdidstr = request.getParameter("fdid");
		if (fdidstr == null) {
			// 分店id获取失败，返回用户列表首页
			return "redirect:sylist";
		}
		int fdid = Integer.valueOf(fdidstr);

		yonghu = new Yonghu();
		yonghu.setFdid(fdid);
		model.addAttribute("yonghu", yonghu);

		rolelist = roleservice.rolequery();
		rolelist.remove(0);
		model.addAttribute("rolelist", rolelist);
		chushilist = chushiservice.chushiquery(fdid);
		model.addAttribute("chushilist", chushilist);
		return "yonghu/add";
	}

	/**
	 * 执行添加用户
	 */
	@RequestMapping("/doadd")
	public String doadd(HttpServletRequest request, Yonghu record, Model model) {
		if (record.getYhbh() == null || record.getYhdlm() == null || record.getYhmm() == null) {
			// 添加失败，用户编号、用户名称、用户密码不能为空
			model.addAttribute("waymsg", "用户添加失败");
			model.addAttribute("bhmsg", "用户编号不能为空");
			model.addAttribute("mcmsg", "用户名称不能为空");
			model.addAttribute("mmmsg", "用户密码不能为空");
			model.addAttribute("yonghu", record);
			return "yonghu/add";
		}

		// 检查重复
		yonghulist = yonghuservice.checkrepeat(record);
		if (yonghulist.size() > 0) {
			// 添加失败，用户编号、用户名不能重复
			for (Yonghu temp : yonghulist) {
				if (temp.getYhbh().equals(record.getYhbh())) {
					model.addAttribute("bhmsg", "此用户编号已存在");
				}
				if (temp.getYhdlm().equals(record.getYhdlm())) {
					model.addAttribute("mcmsg", "此用户名已存在");
				}
			}
			model.addAttribute("waymsg", "用户添加失败");
			model.addAttribute("yonghu", record);

			rolelist = roleservice.rolequery();
			model.addAttribute("rolelist", rolelist);
			chushilist = chushiservice.chushiquery(record.getFdid());
			model.addAttribute("chushilist", chushilist);
			return "yonghu/add";
		}

		if (record.getYhjsid() == 1) {
			record.setYhjsid(5);
		}
		int res = yonghuservice.addyonghu(record);
		if (res > 0) {
			// 添加成功
			return "redirect:list?waymsg=add&&fdid=" + record.getFdid();
		} else {
			// 添加失败
			model.addAttribute("waymsg", "用户添加失败");
			model.addAttribute("yonghu", record);

			rolelist = roleservice.rolequery();
			model.addAttribute("rolelist", rolelist);
			chushilist = chushiservice.chushiquery(record.getFdid());
			model.addAttribute("chushilist", chushilist);
			return "yonghu/add";
		}
	}

	/**
	 * 修改用户
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		yonghu = yonghuservice.getuser(id);
		model.addAttribute("yonghu", yonghu);

		rolelist = roleservice.rolequery();
		model.addAttribute("rolelist", rolelist);
		chushilist = chushiservice.chushiquery(yonghu.getFdid());
		model.addAttribute("chushilist", chushilist);
		return "yonghu/edit";
	}

	/**
	 * 执行修改用户
	 */
	@RequestMapping("/doedit")
	public String doedit(Yonghu record, Model model) {
		if (record.getYhbh() == null || record.getYhdlm() == null || record.getYhmm() == null) {
			// 修改失败，用户编号、用户名称、用户密码不能为空
			model.addAttribute("waymsg", "用户修改失败");
			model.addAttribute("bhmsg", "用户编号不能为空");
			model.addAttribute("mcmsg", "用户名称不能为空");
			model.addAttribute("mmmsg", "用户密码不能为空");
			model.addAttribute("yonghu", record);
			return "yonghu/edit";
		}

		// 检查重复
		yonghulist = yonghuservice.checkrepeat(record);
		if (yonghulist.size() > 0) {
			// 修改失败，用户编号、用户名不能重复
			for (Yonghu temp : yonghulist) {
				if (temp.getYhbh().equals(record.getYhbh())) {
					model.addAttribute("bhmsg", "此用户编号已存在");
				}
				if (temp.getYhdlm().equals(record.getYhdlm())) {
					model.addAttribute("mcmsg", "此用户名已存在");
				}
			}
			model.addAttribute("waymsg", "用户修改失败");
			model.addAttribute("yonghu", record);

			rolelist = roleservice.rolequery();
			model.addAttribute("rolelist", rolelist);
			chushilist = chushiservice.chushiquery(record.getFdid());
			model.addAttribute("chushilist", chushilist);
			return "yonghu/edit";
		}

		if (record.getYhjsid() == 1) {
			record.setYhjsid(null);
		}
		int res = yonghuservice.updateyonghu(record);
		if (res >= 0) {
			// 修改成功
			return "redirect:list?waymsg=edit&&fdid=" + record.getFdid();
		} else {
			// 修改失败
			model.addAttribute("waymsg", "用户修改失败");
			model.addAttribute("yonghu", record);

			rolelist = roleservice.rolequery();
			model.addAttribute("rolelist", rolelist);
			chushilist = chushiservice.chushiquery(record.getFdid());
			model.addAttribute("chushilist", chushilist);
			return "yonghu/edit";
		}
	}

	/**
	 * 删除用户
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		String fdid = request.getParameter("fdid");
		Integer id = Integer.valueOf(request.getParameter("id"));
		int res = yonghuservice.deleteyonghu(id);
		if (res > 0) {
			// 修改成功
			return "redirect:list?waymsg=delete&&fdid=" + fdid;
		} else {
			// 修改失败
			return "redirect:list?waymsg=error&&fdid=" + fdid;
		}
	}

	/**
	 * 搜索用户
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		String fdidstr = request.getParameter("fdid");
		if (fdidstr == null) {
			// 分店id获取失败，返回用户列表首页
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

		yonghu = new Yonghu();
		yonghu.setFdid(fdid);
		yonghu.setYhdlm(searchword);
		yhvolist = yonghuservice.searchyonghu(yonghu, (conpage - 1) * 20);
		model.addAttribute("yonghulist", yhvolist);
		model.addAttribute("count", yonghuservice.getsearchcount(yonghu));
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("fendianlist", fendianlist);
		return "yonghu/searchlist";
	}

	/**
	 * 下载用户列表Excel
	 */
	@RequestMapping("/downloadexcel")
	public ResponseEntity<byte[]> downloadexcel(HttpServletRequest request) throws Exception {
		int fdid = Integer.valueOf(request.getParameter("fdid"));
		String path = yonghuservice.writeexcel(fdid);
		File file = new File(path);
		String fileName = new String("用户列表.xlsx".getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
}
