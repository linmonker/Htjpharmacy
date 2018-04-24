package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Login;
import cn.sdhqtj.hjt.entity.Yonghu;
import cn.sdhqtj.hjt.entity.YonghuVo;

/**
 * 用户mapper补充
 */
public interface YonghuMapperPro {

	/**
	 * 获取用户列表
	 */
	List<YonghuVo> yonghuquery(Integer id);
	
	/**
	 *根据用户名获取用户信息
	 */
	List<Yonghu> getuserByUseranme(String string);
	
	/**
	 *根据用户名称获取用户信息,包括分店名称
	 */
	List<YonghuVo> getuser(String string);

	/**
	 * 搜索用户
	 */
	List<YonghuVo> searchyonghu(Yonghu record);

	/**
	 * 检查重复，用户编号，用户登录名
	 */
	List<Yonghu> checkrepeat(Yonghu record);

	/**
	 * 登录验证
	 */
	Yonghu validatelogon(Login record);

	/**
	 * 更新用户信息
	 */
	void updateyonghu(Yonghu record);

}