/**  
* Title: LoginSer.java  
* Description:登录service实现类  
* @author LIN  
* @date 2018年3月10日  
*/
package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.mapper.LoginMapper;
import cn.sdhqtj.hjt.service.LoginService;

@Service
public class LoginSer implements LoginService {
	
	@Resource
	private LoginMapper loginMapper;

	//登录验证
	@Override
	public List<Login> login(Login login) {
		
		List<Login> list = loginMapper.login(login);
		return list;
	}

	
}
