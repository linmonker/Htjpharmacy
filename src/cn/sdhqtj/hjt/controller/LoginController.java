package cn.sdhqtj.hjt.controller;

import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.service.LoginService;
import cn.sdhqtj.hjt.service.YonghuService;

/**
 * 用户登录controller
 */
@Controller
public class LoginController {

	@Resource
	LoginService loginService;
	Login login;

	@Resource
	YonghuService yonghuService;

	/**
	 * 登录页面
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	/**
	 * 进入首页
	 */
	@RequestMapping("/index")
	public void index() {
		if (login != null) {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(true);
			session.setAttribute("loginer", login);
		}
	}

	/**
	 * 登录操作
	 */
	@RequestMapping("/dologin")
	public Object dologin(Login record, Model model) {

		login = loginService.getuserwithfdmc(record.getUsername());
		// shiro安全框架调用
		Subject subject = SecurityUtils.getSubject();

		// 判断是否已经登录
		if (subject.isAuthenticated()) {
			return "redirect:index";
		}

		// 验证登录
		UsernamePasswordToken token = new UsernamePasswordToken(record.getUsername(), record.getPassword());
		try {
			subject.login(token);

		} catch (IncorrectCredentialsException ice) {
			model.addAttribute("username", record.getUsername());
			model.addAttribute("loginmsg", "用户名或密码不正确");
			return "login";
		}
		return "redirect:index";
	}

	/**
	 * 退出登录
	 */
	@RequestMapping("/outlogin")
	public Object outlogin(Model model) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:login";
	}
}
