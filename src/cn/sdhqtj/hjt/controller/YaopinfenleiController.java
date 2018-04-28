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
			model.addAttribute("editmsg", "药品分类修改成功");
		}
		return "yaopinfenlei/list";
	}

	/**
	 * 列表
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

		Integer lastid = ypflservice.addyaopinfenlei(ypfl);
		return String.valueOf(lastid);
	}

	/**
	 * 执行修改药品分类名称
	 */
	@RequestMapping("/editname")
	@ResponseBody
	public String editname(@RequestBody YaopinflNode record) {
		ypfl = new Yaopinfenlei();
		ypfl.setId(record.getId());
		ypfl.setFlmc(record.getName());
		ypflservice.updatemingchen(ypfl);
		return "success";
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
			model.addAttribute("editmsg", "药品分类修改失败");
			model.addAttribute("bhmsg", "药品分类编号不能为空");
			model.addAttribute("mcmsg", "药品分类名称不能为空");
			model.addAttribute("ypfl", record);
			return "yaopinfenlei/edit";
		}
		ypfl = ypflservice.getyaopinfenlei(record.getId());
		// 判断药品分类编号修改
		if (!ypfl.getFlbh().equals(record.getFlbh())) {
			ypfllist = ypflservice.checkrepeat(record);
			if (ypfllist.size() > 0) {
				// 修改失败，药品分类编号不能重复
				model.addAttribute("bhmsg", "此药品分类编号已存在");
				model.addAttribute("editmsg", "药品分类修改失败");
				model.addAttribute("ypfl", record);
				ypfllist = ypflservice.Yaopinfenleiquery();
				model.addAttribute("ypfllist", ypfllist);
				return "yaopinfenlei/edit";
			}
		}
		// 修改成功
		// 设置药品分类等级
		ypfl = ypflservice.getyaopinfenlei(record.getSjflid());
		record.setFldj((short) (ypfl.getFldj() + 1));
		ypflservice.updateyaopinfenlei(record);
		return "redirect:list?waymsg=edit";

	}

	/**
	 * 删除药品分类
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam(value = "id") Integer id) {
		ypflservice.deleteyaopinfenlei(id);
		return "success";
	}
}
