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
	 * 根据分店id获取用户列表，，包括处室名称
	 */
	List<YonghuVo> yonghuquery(int fdid);

	/**
	 * 根据用户id获取用户信息
	 */
	Yonghu getuser(int id);

	/**
	 * 根据用户名获取用户信息,包括分店名称
	 */
	List<YonghuVo> getuserByUseranme(String string);

	/**
	 * 模糊搜索用户：用户编号，登录名，姓名，姓名简拼，身份证号
	 */
	List<YonghuVo> searchyonghu(Yonghu record);

	/**
	 * 检查重复：用户编号，用户登录名
	 */
	List<Yonghu> checkrepeat(Yonghu record);

	/**
	 * 添加用户
	 */
	int addyonghu(Yonghu record);

	/**
	 * 更新用户信息
	 */
	int updateyonghu(Yonghu record);

	/**
	 * 根据用户id删除用户
	 */
	int deleteyonghu(int id);

	/**
	 * 根据分店id生成用户列表Excel，返回文件路径
	 */
	public String writeexcel(int fdid);

}
