package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Yonghu;
import cn.sdhqtj.hjt.entity.YonghuVo;

/**
 * 用户service接口
 */
@Service
public interface YonghuService {

	/**
	 * 根据分店id获取用户列表
	 */
	List<YonghuVo> yonghuquery(Integer id);

	/**
	 * 根据用户id获取用户信息
	 */
	Yonghu getuser(Integer id);

	/**
	 * 根据用户名获取用户信息
	 */
	List<Yonghu> getuserByUseranme(String string);
	
	/**
	 * 搜索用户
	 */
	List<YonghuVo> searchyonghu(Yonghu record);
	
	/**
	 * 检查重复，用户编号，用户登录名
	 */
	List<Yonghu> checkrepeat(Yonghu record);

	/**
	 * 添加用户
	 */
	void addyonghu(Yonghu record);

	/**
	 * 更新用户信息
	 */
	void updateyonghu(Yonghu record);

	/**
	 * 根据用户id删除用户
	 */
	void deleteyonghu(Integer id);

}
