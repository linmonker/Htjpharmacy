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
	YonghuVo yonghuvo;
	List<YonghuVo> yonghuvolist;
	Login login;

	/**
	 * 登录验证
	 */
	@Override
	public Login validatelogon(Login record) {
		yonghuvolist = yonghuMapperPro.getuserByUseranme(record.getUsername());
		if (yonghuvolist.size() > 0) {
			login = new Login();
			login.setUsername(yonghuvolist.get(0).getYhdlm());
			login.setPassword(yonghuvolist.get(0).getYhmm());
			return login;
		} else {
			return null;
		}
	}

	/**
	 * 根据用户名获取用户信息
	 */
	@Override
	public List<YonghuVo> getuserByUseranme(String string) {
		// TODO Auto-generated method stub
		yonghuvolist = yonghuMapperPro.getuserByUseranme(string);
		return yonghuvolist;
	}

	/**
	 * 根据用户名获取用户信息,包括分店名称,并设置登录信息
	 */
	@Override
	public Login getuserwithfdmc(String string) {
		// TODO Auto-generated method stub
		yonghuvolist = yonghuMapperPro.getuserByUseranme(string);
		if (yonghuvolist.size() > 0) {
			yonghuvo = yonghuvolist.get(0);
			login = new Login();
			login.setId(yonghuvo.getId());
			login.setUsername(yonghuvo.getYhdlm());
			login.setFdid(yonghuvo.getFdid());
			login.setFdmc(yonghuvo.getFdmc());
			return login;
		} else {
			return null;
		}
	}

}
