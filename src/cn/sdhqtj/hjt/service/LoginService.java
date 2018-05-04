package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.entity.YonghuVo;

/**
 *登录service接口
 */
@Service
public interface LoginService {

	/**
	 *登录验证
	 */
	public Login validatelogon(Login record);
	
	/**
	 *根据用户名获取用户信息
	 */
	List<YonghuVo> getuserByUseranme(String string);
	
	/**
	 *根据用户名获取用户信息,包括分店名称,并设置登录信息
	 */
	Login getuserwithfdmc(String string);

}
