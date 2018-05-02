package cn.sdhqtj.hjt.mapper;

import java.util.List;
import cn.sdhqtj.hjt.entity.Huowei;

/**
 * 货位mapper补充
 */

public interface HuoweiMapperPro {

	/**
	 * 根据仓库id获取货位列表
	 */
	List<Huowei> huoweiquery(int id);
	
	/**
	 * 模糊搜索货位：货位名称
	 */
	List<Huowei> searchhuowei(Huowei record);

	/**
	 * 检查重复，货物编号同一仓库唯一
	 */
	List<Huowei> checkrepeat(Huowei record);

	/**
	 * 更新货物信息，部分字段
	 */
	int updatehuowei(Huowei record);

}