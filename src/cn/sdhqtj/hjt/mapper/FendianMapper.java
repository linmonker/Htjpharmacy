package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Fendian;

/**
 * 分店mapper
 */
public interface FendianMapper {
	/**
	 * 根据分店id删除分店信息
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 插入分店信息，全部字段
	 */
	int insert(Fendian record);

	/**
	 * 插入分店信息，不为null字段
	 */
	int insertSelective(Fendian record);

	/**
	 * 根据分店id查询分店信息
	 */
	Fendian selectByPrimaryKey(Integer id);

	/**
	 * 更新分店信息，不为null字段
	 */
	int updateByPrimaryKeySelective(Fendian record);

	/**
	 * 更新分店信息，全部字段
	 */
	int updateByPrimaryKeyWithBLOBs(Fendian record);

	/**
	 * 更新分店信息，不为大字段
	 */
	int updateByPrimaryKey(Fendian record);
}