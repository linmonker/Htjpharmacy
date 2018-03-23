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
	public List<Cangku> cangkuquery(Integer fdid);

	/**
	 * 通过仓库id获取仓库信息
	 */
	public Cangku cangkuget(Integer id);

	/**
	 * 添加仓库
	 */
	public void cangkuadd(Cangku record);

	/**
	 * 根据仓库id删除分店
	 */
	public void cangkudelete(Integer id);

	/**
	 * 更新仓库信息
	 */
	public void cangkuupdate(Cangku record);

}