package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.entity.YaopinflNode;
import cn.sdhqtj.hjt.service.YaopinfenleiService;

/**
 * 药品分类controller
 */
@Controller
@RequestMapping("/yaopinfenlei")
public class YaopinfenleiController {

	@Resource
	YaopinfenleiService ypflservice;
	List<Yaopinfenlei> ypfllist;
	Yaopinfenlei ypfl;
	YaopinflNode ypflnode;
	List<YaopinflNode> ypflnodelist;

	/**
	 * 跳转药品分类页面
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("edit".equals(waymsg)) {
			model.addAttribute("waymsg", "药品分类修改成功");
		}
		if ("error".equals(waymsg)) {
			model.addAttribute("waymsg", "操作失误");
		}
		return "yaopinfenlei/list";
	}

	/**
	 * 获取节点json列表
	 */
	@RequestMapping("/getlist")
	@ResponseBody
	public String getlist() {
		List<YaopinflNode> nlist = ypflservice.getypflnodes();
		String str = JSON.toJSON(nlist).toString();
		return str;
	}

	/**
	 * 执行添加药品分类
	 */
	@RequestMapping("/doadd")
	@ResponseBody
	public String doadd(@RequestBody YaopinflNode record) {

		ypfl = new Yaopinfenlei();
		ypfl.setSjflid(record.getId());
		ypfl.setFldj((short) (record.getLevelid() + 1));
		ypfl.setFlmc("新分类");

		int lastid = ypflservice.addyaopinfenlei(ypfl);
		if (lastid > 0) {
			return String.valueOf(lastid);
		} else {
			return "-1";
		}
	}

	/**
	 * 执行修改药品分类名称
	 */
	@RequestMapping("/editname")
	@ResponseBody
	public String editname(@RequestBody YaopinflNode record) {
		if (record.getName() == null) {
			// 药品分类名称不能为空
			return "error";
		}
		ypfl = new Yaopinfenlei();
		ypfl.setId(record.getId());
		ypfl.setFlmc(record.getName());

		int res = ypflservice.updatemingchen(ypfl);
		if (res >= 0) {
			return "success";
		} else {
			return "error";
		}
	}

	/**
	 * 修改药品分类
	 */
	@RequestMapping("/edit")
	public String edit(Model model, @RequestParam(value = "id") Integer id) {
		ypfl = ypflservice.getyaopinfenlei(id);
		model.addAttribute("ypfl", ypfl);

		ypfllist = ypflservice.Yaopinfenleiquery();
		model.addAttribute("ypfllist", ypfllist);
		return "yaopinfenlei/edit";
	}

	/**
	 * 执行修改药品分类
	 */
	@RequestMapping("/doedit")
	public String doedit(Yaopinfenlei record, Model model) {
		if (record.getFlbh() == null || record.getFlmc() == null) {
			// 修改失败，药品分类编号、药品分类名称不能为空
			model.addAttribute("waymsg", "药品分类修改失败");
			model.addAttribute("bhmsg", "药品分类编号不能为空");
			model.addAttribute("mcmsg", "药品分类名称不能为空");
			model.addAttribute("ypfl", record);
			return "yaopinfenlei/edit";
		}

		// 检查重复
		ypfllist = ypflservice.checkrepeat(record);
		if (ypfllist.size() > 0) {
			// 修改失败，药品分类编号不能重复
			model.addAttribute("bhmsg", "此药品分类编号已存在");
			model.addAttribute("waymsg", "药品分类修改失败");
			model.addAttribute("ypfl", record);
			ypfllist = ypflservice.Yaopinfenleiquery();
			model.addAttribute("ypfllist", ypfllist);
			return "yaopinfenlei/edit";
		}

		// 设置药品分类等级
		ypfl = ypflservice.getyaopinfenlei(record.getSjflid());
		record.setFldj((short) (ypfl.getFldj() + 1));

		int res = ypflservice.updateyaopinfenlei(record);
		if (res > 0) {
			// 修改成功
			return "redirect:list?waymsg=edit";
		} else {
			// 修改失败
			model.addAttribute("waymsg", "药品分类修改失败");
			model.addAttribute("ypfl", record);
			ypfllist = ypflservice.Yaopinfenleiquery();
			model.addAttribute("ypfllist", ypfllist);
			return "yaopinfenlei/edit";
		}
	}

	/**
	 * 删除药品分类
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam(value = "id") Integer id) {
		int res = ypflservice.deleteyaopinfenlei(id);
		if (res > 0) {
			// 删除成功
			return "success";
		} else {
			// 删除失败
			return "error";
		}
	}

}
