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

		String waymsg = request.getParameter("waymsg");
		if ("edit".equals(waymsg)) {
			model.addAttribute("editmsg", "分店修改成功");
		}
		return "yaopinfenlei/list";
	}

	/**
	 * 列表
	 */
	@RequestMapping("/getlist")
	@ResponseBody
	public String  getlist() {
		List<YaopinflNode> nlist =  ypflservice.getypflnodes();
		String str=JSON.toJSON(nlist).toString();
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
		ypfl = ypflservice.checkrepeat(record);

		if (record.getFlbh() == null || record.getFlmc() == null || ypfl != null) {
			// 修改失败
			if (ypfl != null) {
				model.addAttribute("bhmsg", "此药品分类编号已存在");
			}

			model.addAttribute("editmsg", "药品分类修改失败");
			model.addAttribute("ypfl", record);
			ypfllist = ypflservice.Yaopinfenleiquery();
			model.addAttribute("ypfllist", ypfllist);
			return "yaopinfenlei/edit";
		} else {// 修改成功
			ypfl = ypflservice.getyaopinfenlei(record.getSjflid());
			record.setFldj((short) (ypfl.getFldj() + 1));
			ypflservice.updateyaopinfenlei(record);
			return "redirect:list?waymsg=edit";
		}
	}

	/**
	 * 删除药品分类
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(HttpServletRequest request, @RequestParam(value = "id") Integer id) {
		ypflservice.deleteyaopinfenlei(id);
		return "success";
	}
}
