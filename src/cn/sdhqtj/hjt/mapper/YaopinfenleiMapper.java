package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Yaopinfenlei;

/**
 * 药品分类mapper
 */
public interface YaopinfenleiMapper {
	/**
	 * 根据药品分类id删除药品
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 插入药品分类，全部字段
	 */
	int insert(Yaopinfenlei record);

	/**
	 * 插入药品分类，不为null字段
	 */
	int insertSelective(Yaopinfenlei record);

	/**
	 * 根据药品分类id查询药品分类信息
	 */
	Yaopinfenlei selectByPrimaryKey(Integer id);

	/**
	 * 更新药品分类信息，不为null字段
	 */
	int updateByPrimaryKeySelective(Yaopinfenlei record);

	/**
	 * 更新药品分类信息，全部字段
	 */
	int updateByPrimaryKeyWithBLOBs(Yaopinfenlei record);

	/**
	 * 更新药品分类信息，不含大字段
	 */
	int updateByPrimaryKey(Yaopinfenlei record);
}