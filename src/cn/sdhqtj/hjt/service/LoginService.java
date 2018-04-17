package cn.sdhqtj.hjt.service;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Login;

/**
 *登录service接口
 */
@Service
public interface LoginService {

	/**
	 *登录验证
	 */
	public Login validatelogon(Login record);

}
