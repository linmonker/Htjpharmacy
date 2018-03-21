/**  
* Title: LoginSer.java  
* Description:登录service接口  
* @author LIN  
* @date 2018年3月10日  
*/
package cn.sdhqtj.hjt.service;

import java.util.List;
import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Login;

@Service
public interface LoginService {

	// 登录验证
	public List<Login> login(Login login);

}
