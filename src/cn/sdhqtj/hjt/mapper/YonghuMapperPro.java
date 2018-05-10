package cn.sdhqtj.hjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	 * 根据分店id获取用户列表，包括处室名，从start开始20条记录
	 */
	List<YonghuVo> getlist(@Param("fdid") int fdid, @Param("start") int start);

	/**
	 * 根据分店id获取用户列表记录数
	 */
	int getcount(@Param("fdid") int fdid);

	/**
	 * 模糊搜索用户：用户编号，登录名，姓名，姓名简拼，身份证号，仓库名称，从start开始20条记录
	 */
	List<YonghuVo> searchyonghu(@Param("yonghu") Yonghu record, @Param("start") int start);

	/**
	 * 搜索用户列表记录数
	 */
	int getsearchcount(@Param("yonghu") Yonghu record);

	/**
	 * 根据分店id获取用户Excel列表
	 */
	List<YonghuVo> getexcellist(int fdid);

	/**
	 * 检查重复：用户编号，用户登录名
	 */
	List<Yonghu> checkrepeat(Yonghu record);

	/**
	 * 根据用户名获取用户信息,包括分店名称
	 */
	List<YonghuVo> getuserByUseranme(String string);

	/**
	 * 更新用户信息
	 */
	int updateyonghu(Yonghu record);

}