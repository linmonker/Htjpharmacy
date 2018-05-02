package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Cangku;

/**
 * 仓库service接口
 */
@Service
public interface CangkuService {

	/**
	 * 根据分店id获取仓库列表
	 */
	public List<Cangku> cangkuquery(int id);

	/**
	 * 通过仓库id获取仓库信息
	 */
	public Cangku getcangku(int id);

	/**
	 * 模糊搜索仓库：仓库编号，仓库名称
	 */
	public List<Cangku> searchcangku(Cangku record);

	/**
	 * 检查重复：仓库编号每个分店唯一
	 */
	List<Cangku> checkrepeat(Cangku record);

	/**
	 * 添加仓库
	 */
	public int addcangku(Cangku record);

	/**
	 * 根据仓库id删除分店
	 */
	public int deletecangku(int id);

	/**
	 * 更新仓库信息，部分字段
	 */
	public int updatecangku(Cangku record);

}