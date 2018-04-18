package cn.sdhqtj.hjt.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.service.LoginService;

/**
 *用户登录controller
 */
@Controller
public class LoginController {

	@Resource
	LoginService loginService;
	Login login;

	/**
	 *登录页面
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	/**
	 *登录操作
	 */
	@RequestMapping("/dologin")
	public Object dologin(Login record, Model model, HttpSession session) {

		login = loginService.validatelogon(record);
		if (login == null) {
			model.addAttribute("username", login.getUsername());
			model.addAttribute("loginmsg", "用户名或密码不正确");
			return "login";
		} else {
			session.setAttribute("longiner", login);
			return "index";
		}
	}

	/**
	 *退出登录
	 */
	@RequestMapping("/outlogin")
	public Object outlogin(HttpSession session, Model model) {
		if (session.getAttribute("loginer") != null) {
			session.removeAttribute("loginer");
		}
		return "redirect:login";
	}
}
