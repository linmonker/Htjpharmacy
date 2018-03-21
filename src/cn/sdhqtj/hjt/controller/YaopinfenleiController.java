/**  
* Title: YaopinfenleiController.java  
* Description:药品分类控制器  
* @author LIN  
* @date 2018年3月10日  
*/
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

	// 跳转药品分类页面
	@RequestMapping("/list")
	public String toListLibrary() {
		return "yaopinfenlei/list";
	}

	// 列表
	@RequestMapping("/getlist")
	@ResponseBody
	public List<Object> list() {
		return ypflservice.Yaopinfenleiquery();

	}

	// 执行添加药品分类
	@RequestMapping("/doadd")
	@ResponseBody
	public String doadd(@RequestBody YaopinflNode ypflnodetemp) {

		ypfltemp = new Yaopinfenlei();
		ypfltemp.setSjflid(ypflnodetemp.getId());
		ypfltemp.setFldj((short) (ypflnodetemp.getLevelid() + 1));
		ypfltemp.setFlmc("新分类");
		ypfltemp.setZt(0);

		Integer lastid = ypflservice.yaopinfenleiadd(ypfltemp);
		System.out.println("最后插入" + lastid);
		return String.valueOf(lastid);
	}

	// 执行修改药品分类
	@RequestMapping("/doedit")
	@ResponseBody
	public String doedit(@RequestBody YaopinflNode ypflnodetemp) {
		ypfltemp = new Yaopinfenlei();
		ypfltemp.setId(ypflnodetemp.getId());
		ypfltemp.setFldj((short) (ypflnodetemp.getLevelid() + 1));
		ypfltemp.setSjflid(ypflnodetemp.getPId());
		ypfltemp.setFlmc(ypflnodetemp.getName());
		ypfltemp.setZt(0);
		ypflservice.yaopinfenleiupdate(ypfltemp);
		return "success";
	}

	// 删除药品分类
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(HttpServletRequest request, @RequestParam(value = "id") Integer id) {

		ypflservice.yaopinfenleidelete(id);
		return "success";
	}

}
