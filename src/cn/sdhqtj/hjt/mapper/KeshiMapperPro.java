package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Keshi;

/**
 * 科室mapper补充
 */
public interface KeshiMapperPro {

	/**
	 * 根据分店id获取科室列表
	 */
	List<Keshi> keshiquery(Integer id);

	/**
	 * 检查重复检查重复，科室编号同一分店唯一
	 */
	List<Keshi> checkrepeat(Keshi record);

	/**
	 * 更新科室信息
	 */
	void updatekeshi(Keshi record);

}