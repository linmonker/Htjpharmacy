package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Yonghu;
import cn.sdhqtj.hjt.entity.YonghuVo;

/**
 * 用户mapper补充
 */
public interface YonghuMapperPro {

	/**
	 * 根据分店id获取用户列表，包括处室名称
	 */
	List<YonghuVo> yonghuquery(int fdid);
	
	/**
	 * 根据分店id获取用户Excel列表
	 */
	List<YonghuVo> getexcellist(int fdid);

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
	 * 更新用户信息
	 */
	int updateyonghu(Yonghu record);

}