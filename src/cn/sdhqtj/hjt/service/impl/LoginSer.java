package cn.sdhqtj.hjt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.entity.Yonghu;
import cn.sdhqtj.hjt.entity.YonghuVo;
import cn.sdhqtj.hjt.mapper.YonghuMapperPro;
import cn.sdhqtj.hjt.service.LoginService;

/**
 * 登录service接口实现类
 */
@Service
public class LoginSer implements LoginService {

	@Resource
	private YonghuMapperPro yonghuMapperPro;
	Yonghu yonghu;
	List<Yonghu> yonghulist;
	Login login;
	YonghuVo yonghup;

	/**
	 * 登录验证
	 */
	@Override
	public Login validatelogon(Login record) {
		yonghu = yonghuMapperPro.validatelogon(record);
		if (yonghu != null) {
			return login;
		} else {
			return null;
		}
	}

	/**
	 * 根据用户名获取用户信息
	 */
	@Override
	public List<Yonghu> getuserByUseranme(String string) {
		// TODO Auto-generated method stub
		yonghulist = yonghuMapperPro.getuserByUseranme(string);
		return yonghulist;
	}

	/**
	 * 根据用户名获取用户信息,包括分店名称,并设置登录信息
	 */
	@Override
	public Login getuserwithfdmc(String string) {
		// TODO Auto-generated method stub
		yonghup = yonghuMapperPro.getuser(string).get(0);
		login = new Login();
		login.setId(yonghup.getId());
		login.setUsername(yonghup.getYhdlm());
		login.setFdid(yonghup.getFdid());
		login.setFdmc(yonghup.getFdmc());
		return login;
	}
}
