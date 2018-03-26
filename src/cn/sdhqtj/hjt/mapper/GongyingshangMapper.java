package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;

/**
 * 供应商mapper
 */
public interface GongyingshangMapper {
	/**
	 * 根据供应商id删除供应商信息
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 插入供应商，全部字段
	 */
	int insert(GongyingshangWithBLOBs record);

	/**
	 * 插入供应商，不为null字段
	 */
	int insertSelective(GongyingshangWithBLOBs record);

	/**
	 * 根据供应商id查询供应商信息
	 */
	GongyingshangWithBLOBs selectByPrimaryKey(Integer id);

	/**
	 * 更新供应商信息，不为null字段
	 */
	int updateByPrimaryKeySelective(GongyingshangWithBLOBs record);

	/**
	 * 更新供应商信息，全部字段
	 */
	int updateByPrimaryKeyWithBLOBs(GongyingshangWithBLOBs record);

	/**
	 * 更新供应商信息，不含大字段
	 */
	int updateByPrimaryKey(Gongyingshang record);
}