package cn.sdhqtj.hjt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.service.LoginService;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;

@Controller
public class LoginController {
	
	@Resource
	LoginService loginService;
	List<Login> list;
	
//	登录页面
	@RequestMapping("/login")
	public String login (){
		return "login";
	}
	//免登陆去首页
	@RequestMapping("/index")
	public String index (){
		return "index";
	}

//	登录操作
	@RequestMapping("/dologin")
	public Object dologin ( Login login,Model model ){

		list = loginService.login(login);
		if(list.isEmpty()) {
			model.addAttribute("login",login.getLogin());
			model.addAttribute("data","用户名或密码不正确");
			return "login";
		}
		else {
			return "redirect:index";
		}

	}
	
//	退出登录
	@RequestMapping("/outlogin")
	public Object outlogin (HttpSession session,Model model){
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		return "redirect:login";
	}
}
