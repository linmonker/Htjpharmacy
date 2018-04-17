package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.entity.Yonghu;
import cn.sdhqtj.hjt.entity.YonghuPro;

/**
 * 用户mapper补充
 */
public interface YonghuMapperPro {

	/**
	 * 获取用户列表
	 */
	List<Yonghu> yonghuquery();

	/**
	 * 检查重复，登录名
	 */
	Yonghu checkrepeat(Yonghu record);

	/**
	 * 更新用户信息
	 */
	void updateyonghu(Yonghu record);

	/**
	 * 登录验证
	 */
	YonghuPro validatelogon(Login record);

}