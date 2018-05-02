package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Cangku;

/**
 * 仓库mapper补充
 */
public interface CangkuMapperPro {

	/**
	 * 根据分店id获取仓库列表
	 */
	List<Cangku> cangkuquery(int id);
	
	/**
	 * 模糊搜索仓库：仓库编号，仓库名称
	 */
	List<Cangku> searchcangku(Cangku record);

	/**
	 *检查重复：仓库编号每个分店唯一
	 */
	List<Cangku> checkrepeat(Cangku record);

	/**
	 * 更新仓库信息，部分字段
	 */
	int updatecangku(Cangku record);
}