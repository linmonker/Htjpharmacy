package cn.sdhqtj.hjt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 信息controller
 */
@Controller
@RequestMapping("/info")
public class InfoController {

	/**
	 * 权限不足信息
	 */
	@RequestMapping("/quanxianerror")
	public String list() {
		return "info/quanxianerror";	
	}
}
