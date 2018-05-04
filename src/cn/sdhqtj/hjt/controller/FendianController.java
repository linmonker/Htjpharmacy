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
import cn.sdhqtj.hjt.service.FendianService;

/**
 * 分店controller
 */
@Controller
@RequestMapping("/fendian")
public class FendianController {

	@Resource
	FendianService fendianservice;
	Fendian fendian;
	List<Fendian> fendianlist;

	/**
	 * 分店列表
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		fendianlist = fendianservice.fendianquery();
		model.addAttribute("fendianlist", fendianlist);

		// 操作提示信息
		String waymsg = request.getParameter("waymsg");
		if ("add".equals(waymsg)) {
			model.addAttribute("waymsg", "分店添加成功");
		} else if ("edit".equals(waymsg)) {
			model.addAttribute("waymsg", "分店修改成功");
		} else if ("delete".equals(waymsg)) {
			model.addAttribute("waymsg", "分店删除成功");
		} else if ("error".equals(waymsg)) {
			model.addAttribute("waymsg", "操作失误");
		}
		return "fendian/list";
	}

	/**
	 * 添加分店
	 */
	@RequestMapping("/add")
	public String add() {
		return "fendian/add";
	}

	/**
	 * 执行添加分店
	 */
	@RequestMapping("/doadd")
	public String doadd(Fendian record, Model model) {
		if (record.getFdbh() == null || record.getFdmc() == null) {
			// 添加失败，分店编号、分店名称不能为空
			model.addAttribute("waymsg", "分店添加失败");
			model.addAttribute("bhmsg", "分店编号不能为空");
			model.addAttribute("mcmsg", "分店名称不能为空");
			model.addAttribute("fendian", record);
			return "fendian/add";
		}

		// 检查重复
		fendianlist = fendianservice.checkrepeat(record);
		if (fendianlist.size() > 0) {
			// 添加失败，分店编号或分店名称不能重复
			for (Fendian temp : fendianlist) {
				if (temp.getFdbh().equals(record.getFdbh())) {
					model.addAttribute("bhmsg", "此分店编号已存在");
				}
				if (temp.getFdmc().equals(record.getFdmc())) {
					model.addAttribute("mcmsg", "此分店名称已存在");
				}
			}
			model.addAttribute("waymsg", "分店添加失败");
			model.addAttribute("fendian", record);
			return "fendian/add";
		}

		// 尝试添加
		int res = fendianservice.addfendian(record);
		if (res > 0) {
			// 添加成功
			return "redirect:list?waymsg=add";
		} else {
			// 添加失败
			model.addAttribute("waymsg", "分店添加失败");
			model.addAttribute("fendian", record);
			return "fendian/add";
		}
	}

	/**
	 * 修改分店
	 */
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, Model model) {
		fendian = fendianservice.getfendian(Integer.valueOf(request.getParameter("id")));
		model.addAttribute("fendian", fendian);
		return "fendian/edit";
	}

	/**
	 * 执行修改分店
	 */
	@RequestMapping("/doedit")
	public String doedit(Fendian record, Model model) {
		if (record.getFdbh() == null || record.getFdmc() == null) {
			// 修改失败，分店编号、分店名称不能为空
			model.addAttribute("waymsg", "分店修改失败");
			model.addAttribute("bhmsg", "分店编号不能为空");
			model.addAttribute("mcmsg", "分店名称不能为空");
			model.addAttribute("fendian", record);
			return "fendian/edit";
		}

		// 检查重复
		fendianlist = fendianservice.checkrepeat(record);
		if (fendianlist.size() > 0) {
			// 修改失败，分店编号或分店名称不能重复
			for (Fendian temp : fendianlist) {
				if (temp.getFdbh().equals(record.getFdbh())) {
					model.addAttribute("bhmsg", "此分店编号已存在");
				}
				if (temp.getFdmc().equals(record.getFdmc())) {
					model.addAttribute("mcmsg", "此分店名称已存在");
				}
			}
			model.addAttribute("waymsg", "分店修改失败");
			model.addAttribute("fendian", record);
			return "fendian/edit";
		}

		// 尝试修改
		int res = fendianservice.updatefendian(record);
		if (res >= 0) {
			// 修改成功
			return "redirect:list?waymsg=edit";
		} else {
			// 修改失败
			model.addAttribute("waymsg", "分店修改失败");
			model.addAttribute("fendian", record);
			return "fendian/edit";
		}
	}

	/**
	 * 删除分店
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		// 尝试删除
		int res = fendianservice.deletefendian(Integer.valueOf(request.getParameter("id")));
		if (res > 0) {
			// 删除成功
			return "redirect:list?waymsg=delete";
		} else {
			// 删除失败
			return "redirect:list?waymsg=error";
		}
	}

	/**
	 * 搜索分店
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request, String searchword, Model model) {
		fendian = new Fendian();
		fendian.setFdmc(searchword);
		fendianlist = fendianservice.searchfendian(fendian);
		model.addAttribute("fendianlist", fendianlist);
		return "fendian/list";
	}

	/**
	 * 下载分店列表Excel
	 */
	@RequestMapping("/downloadexcel")
	public ResponseEntity<byte[]> downloadexcel() throws Exception {
		String path = fendianservice.writeexcel();
		File file = new File(path);
		String fileName = new String("分店列表.xlsx".getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

}
