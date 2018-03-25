package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Zuzhijigou;

public interface ZuzhijigouMapperPro {
	/**
	 * 根据分店id获取处室列表
	 */
	List<Zuzhijigou> chushiquery(Integer id);

	/**
	 * 检查重复检查重复同一分店一个处室编号和名称
	 */
	List<Zuzhijigou> checkrepeat(Zuzhijigou record);
}