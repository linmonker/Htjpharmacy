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
	 * 获取分店列表,从start位置开始20条记录
	 */
	List<Fendian> getlist(int start);

	/**
	 * 获取分店列表记录数
	 */
	int getcount();


	/**
	 * 通过分店id获取分店信息
	 */
	public Fendian getfendian(int id);

	/**
	 * 模糊搜索分店：分店名称
	 */
	public List<Fendian> searchfendian(Fendian record);

	/**
	 * 检查重复：分店编号，分店名称
	 */
	public List<Fendian> checkrepeat(Fendian record);

	/**
	 * 添加分店
	 */
	public int addfendian(Fendian record);

	/**
	 * 根据分店id删除分店
	 */
	public int deletefendian(int id);

	/**
	 * 更新分店信息，部分字段
	 */
	public int updatefendian(Fendian record);
	
	/**
	 * 生成分店列表Excel，返回文件路径
	 */
	public String writeexcel();

}