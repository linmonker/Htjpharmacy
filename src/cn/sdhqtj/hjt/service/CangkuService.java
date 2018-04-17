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
	public List<Cangku> cangkuquery(Integer id);

	/**
	 * 通过仓库id获取仓库信息
	 */
	public Cangku getcangku(Integer id);
	
	/**
	 *检查重复，仓库编号每个分店唯一
	 */
	Cangku checkrepeat(Cangku record);

	/**
	 * 添加仓库
	 */
	public void addcangku(Cangku record);

	/**
	 * 根据仓库id删除分店
	 */
	public void deletecangku(Integer id);

	/**
	 * 更新仓库信息
	 */
	public void updatecangku(Cangku record);

}