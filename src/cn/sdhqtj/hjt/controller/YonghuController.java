package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
	public String sylist(Model model) {
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("fendianlist", fendianlist);
		return "yonghu/sylist";
	}

	/**
	 * 用户列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		Integer fdid = Integer.valueOf(request.getParameter("fdid"));
		if (fdid == null) {
			// 分店id获取失败，返回用户列表首页
			return "redirect:sylist";
		}
		yhvolist = yonghuservice.yonghuquery(fdid);
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
			model.addAttribute("addmsg", "用户添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "用户修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("deletemsg", "用户删除成功");
		}
		return "yonghu/list";
	}

	/**
	 * 新增用户
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		Integer fdid = Integer.valueOf(request.getParameter("fdid"));
		if (fdid == null) {
			// 分店id获取失败，返回用户列表首页
			return "redirect:sylist";
		}
		yonghu = new Yonghu();
		yonghu.setFdid(fdid);
		model.addAttribute("yonghu", yonghu);

		rolelist = roleservice.rolequery();
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
			model.addAttribute("addmsg", "用户添加失败");
			model.addAttribute("bhmsg", "用户编号不能为空");
			model.addAttribute("mcmsg", "用户名称不能为空");
			model.addAttribute("mmmsg", "用户密码不能为空");
			model.addAttribute("yonghu", record);
			return "yonghu/add";
		}
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
			model.addAttribute("addmsg", "用户添加失败");
			model.addAttribute("yonghu", record);

			rolelist = roleservice.rolequery();
			model.addAttribute("rolelist", rolelist);
			chushilist = chushiservice.chushiquery(record.getFdid());
			model.addAttribute("chushilist", chushilist);

			return "yonghu/add";
		}
		// 添加成功
		yonghuservice.addyonghu(record);
		return "redirect:list?waymsg=add&&fdid=" + record.getFdid();
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
			model.addAttribute("editmsg", "用户修改失败");
			model.addAttribute("bhmsg", "用户编号不能为空");
			model.addAttribute("mcmsg", "用户名称不能为空");
			model.addAttribute("mmmsg", "用户密码不能为空");
			model.addAttribute("yonghu", record);
			return "yonghu/edit";
		}
		yonghu = yonghuservice.getuser(record.getId());
		// 判断用户编号、用户名修改
		yonghu = yonghuservice.getuser(record.getId());
		if ((!yonghu.getYhbh().equals(record.getYhbh())) || (!yonghu.getYhdlm().equals(record.getYhdlm()))) {
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
				model.addAttribute("editmsg", "用户修改失败");
				model.addAttribute("yonghu", record);

				rolelist = roleservice.rolequery();
				model.addAttribute("rolelist", rolelist);
				chushilist = chushiservice.chushiquery(record.getFdid());
				model.addAttribute("chushilist", chushilist);
				return "yonghu/edit";
			}
		}
		// 修改成功
		yonghuservice.updateyonghu(record);
		return "redirect:list?waymsg=edit&&fdid=" + record.getFdid();
	}

	/**
	 * 删除用户
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer fdid = Integer.valueOf(request.getParameter("fdid"));
		yonghuservice.deleteyonghu(id);
		return "redirect:list?waymsg=delete&&fdid=" + fdid;
	}

	/**
	 * 搜索用户
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, String searchword, Model model) {
		Integer fdid = Integer.valueOf(request.getParameter("fdid"));
		yonghu = new Yonghu();
		yonghu.setFdid(fdid);
		yonghu.setYhbh(searchword);
		yonghu.setYhdlm(searchword);
		yonghu.setYhxm(searchword);
		yonghu.setYhxmjp(searchword);
		yonghu.setYhsfzh(searchword);
		yhvolist = yonghuservice.searchyonghu(yonghu);
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("yonghulist", yhvolist);
		model.addAttribute("fendianlist", fendianlist);
		return "yonghu/list";
	}
}
