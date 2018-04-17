package cn.sdhqtj.hjt.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.entity.YonghuPro;
import cn.sdhqtj.hjt.mapper.YonghuMapperPro;
import cn.sdhqtj.hjt.service.LoginService;

/**
 *登录service接口实现类
 */
@Service
public class LoginSer implements LoginService {

	@Resource
	private YonghuMapperPro yonghuMapperPro;
	YonghuPro yonghup;
	Login login;

	/**
	 *登录验证
	 */
	@Override
	public Login validatelogon(Login record) {
		yonghup = yonghuMapperPro.validatelogon(record);
		if(yonghup != null) {
			login = new Login();
			login.setId(yonghup.getId());
			login.setUsername(yonghup.getYhdlm());
			login.setFdid(yonghup.getFdid());
			login.setFdmc(yonghup.getFdmc());
			return login;
		}else {
			return null;
		}
	}
}
