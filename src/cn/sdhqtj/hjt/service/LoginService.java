package cn.sdhqtj.hjt.service;

import java.util.List;
import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Login;

@Service
public interface LoginService {
	
	public List<Login> login( Login login );
	
	
}
