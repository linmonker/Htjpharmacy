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
	public Fendian getfendian(Integer id);
	
	/**
	 * 搜索分店
	 */
	public List<Fendian> searchfendian(Fendian record);


	/**
	 * 检查重复，分店编号和分店名称
	 */
	public List<Fendian> checkrepeat(Fendian record);

	/**
	 * 添加分店
	 */
	public void addfendian(Fendian record);

	/**
	 * 根据分店id删除分店
	 */
	public void deletefendian(Integer id);

	/**
	 * 更新分店信息
	 */
	public void updatefendian(Fendian record);

}