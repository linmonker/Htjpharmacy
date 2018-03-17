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

	@Override
	public List<Login> login(Login login) {
		
		List<Login> list = loginMapper.login(login);
		return list;
	}

	
}
