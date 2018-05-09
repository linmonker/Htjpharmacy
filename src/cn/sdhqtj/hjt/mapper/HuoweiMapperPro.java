package cn.sdhqtj.hjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sdhqtj.hjt.entity.Huowei;
import cn.sdhqtj.hjt.entity.HuoweiVo;

/**
 * 货位mapper补充
 */

public interface HuoweiMapperPro {

	/**
	 * 根据仓库id获取货位列表
	 */
	List<Huowei> huoweiquery(int ckid);
	
	/**
	 * 根据仓库id获取货位列表，从start开始20条记录
	 */
	List<Huowei> getlist(@Param("ckid") int ckid, @Param("start") int start);

	/**
	 * 根据仓库id获取货位列表记录数
	 */
	int getcount(@Param("ckid") int ckid);

	/**
	 * 模糊搜索货位：货位名称，从start开始20条记录
	 */
	List<Huowei> searchhuowei(@Param("huowei") Huowei record, @Param("start") int start);

	/**
	 * 搜索仓库列表记录数
	 */
	int getsearchcount(@Param("huowei") Huowei record);

	/**
	 * 根据仓库id获取货位Excel列表
	 */
	List<HuoweiVo> getexcellist(int ckid);

	/**
	 * 检查重复，货物编号同一仓库唯一
	 */
	List<Huowei> checkrepeat(Huowei record);

	/**
	 * 更新货物信息，部分字段
	 */
	int updatehuowei(Huowei record);

}