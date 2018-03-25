package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Keshi;

/**
 * 科室mapper增
 */
public interface KeshiMapperPro {

	/**
	 * 根据分店id获取科室列表
	 */
	List<Keshi> keshiquery(Integer id);

	/**
	 * 检查重复检查重复同一分店一个科室编号和名称
	 */
	List<Keshi> checkrepeat(Keshi record);

}