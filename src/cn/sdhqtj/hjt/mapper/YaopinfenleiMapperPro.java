package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.entity.YaopinfenleiVo;

/**
 * 药品分类mapper补充
 */
public interface YaopinfenleiMapperPro {

	/**
	 * 获取药品分类列表
	 */
	List<Yaopinfenlei> Yaopinfenleiquery();

	/**
	 * 检查重复，药品分类编号
	 */
	Yaopinfenlei checkrepeat(Yaopinfenlei record);

	/**
	 * 插入药品分类，不为null字段，返回id
	 */
	Integer insertSelective(Yaopinfenlei record);

	/**
	 * 根据药品分类id获取药品分类信息
	 */
	YaopinfenleiVo getyaopinfenlei(Integer id);

	/**
	 * 更新药品分类
	 */
	YaopinfenleiVo updateyaopinfenlei(Yaopinfenlei record);
}