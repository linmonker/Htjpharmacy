package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.entity.YaopinflNode;
import cn.sdhqtj.hjt.service.YaopinfenleiService;

@Controller
@RequestMapping("/yaopinfenlei")
public class YaopinfenleiController {

	@Resource
	YaopinfenleiService ypflservice;
	List<Yaopinfenlei> ypfllist;
	Yaopinfenlei ypfltemp;
	YaopinflNode ypflnodetemp;
	List<YaopinflNode> ypflnodelist;

	// 列表
	@RequestMapping("/list")
	public @ResponseBody List<YaopinflNode> list() {
		ypflnodelist = ypflservice.Yaopinfenleiquery();

		return ypflnodelist;
	}

	// 执行添加药品分类
	@RequestMapping("/doadd")
	public @ResponseBody String doadd(@RequestBody YaopinflNode ypflnodetemp) {

		ypfltemp.setSjflid(ypflnodetemp.getId());
		ypfltemp.setFldj((short) (ypflnodetemp.getLevel_id() + 1));
		ypfltemp.setFlmc("新分类");
		ypfltemp.setZt(0);
		
		return ypflservice.yaopinfenleiadd(ypfltemp);
		
	}

	// 执行修改药品分类
	@RequestMapping("/doedit")
	public @ResponseBody String doedit(@RequestBody YaopinflNode ypflnodetemp) {
		ypfltemp.setId(ypflnodetemp.getId());
		ypfltemp.setFldj(ypflnodetemp.getLevel_id());
		ypfltemp.setSjflid(ypflnodetemp.getPid());
		ypfltemp.setFlmc(ypflnodetemp.getName());
		ypfltemp.setZt(0);
		ypflservice.yaopinfenleiupdate(ypfltemp);
		return "success";

	}

	// 删除药品分类
	@RequestMapping("/delete")
	public @ResponseBody String delete(HttpServletRequest request,@RequestParam(value = "id") Integer id) {
	
		ypflservice.yaopinfenleidelete(id);
		return "success";
	}

}
