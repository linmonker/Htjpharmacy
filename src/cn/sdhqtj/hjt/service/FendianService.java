package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Fendian;

/**
 * 分店service接口
 */
@Service
public interface FendianService {

	/**
	 * 获取分店列表
	 */
	public List<Fendian> fendianquery();

	/**
	 * 通过分店id获取分店信息
	 */
	public Fendian fendianget(Integer id);

	/**
	 * 通过分店编号获取分店信息
	 */
	public Fendian selectByfdbh(String fdbh);

	/**
	 * 通过分店名称获取分店信息
	 */
	public Fendian selectByfdmc(String fdmc);

	/**
	 * 添加分店
	 */
	public void fendianadd(Fendian fendian);

	/**
	 * 根据分店id删除分店
	 */
	public void fendiandelete(Integer id);

	/**
	 * 更新分店信息
	 */
	public void fendianupdate(Fendian fendian);

}