package cn.sdhqtj.hjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sdhqtj.hjt.entity.Zuzhijigou;
import cn.sdhqtj.hjt.entity.ZuzhijigouVo;

/**
 * 处室mapper补充
 */
public interface ZuzhijigouMapperPro {
	/**
	 * 根据分店id获取处室列表
	 */
	List<Zuzhijigou> chushiquery(int fdid);
	
	/**
	 * 根据分店id获取处室列表，从start开始20条记录
	 */
	List<Zuzhijigou> getlist(@Param("fdid") int fdid, @Param("start") int start);

	/**
	 * 根据分店id获取处室列表记录数
	 */
	int getcount(@Param("fdid") int fdid);

	/**
	 * 模糊搜索处室：处室名称，从start开始20条记录
	 */
	List<Zuzhijigou> searchchushi(@Param("chushi") Zuzhijigou record, @Param("start") int start);

	/**
	 * 搜索处室列表记录数
	 */
	int getsearchcount(@Param("chushi") Zuzhijigou record);
	
	/**
	 * 根据分店id获取处室Excel列表
	 */
	List<ZuzhijigouVo> getexcellist(int fdid);

	/**
	 * 检查重复：处室编号同一分店唯一
	 */
	List<Zuzhijigou> checkrepeat(Zuzhijigou record);

	/**
	 * 更新处室信息
	 */
	int updatechushi(Zuzhijigou record);
}