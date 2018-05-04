package cn.sdhqtj.hjt.service;

import java.util.List;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Zuzhijigou;

/**
 * 处室service接口
 */
@Service
public interface ChushiService {

	/**
	 * 根据分店id获取处室列表
	 */
	public List<Zuzhijigou> chushiquery(int id);

	/**
	 * 根据处室id获取处室信息
	 */
	public Zuzhijigou getchushi(int id);
	
	/**
	 * 模糊搜索处室：处室名称
	 */
	List<Zuzhijigou> searchchushi(Zuzhijigou record);

	/**
	 * 检查重复：处室编号同一分店唯一
	 */
	public List<Zuzhijigou> checkrepeat(Zuzhijigou record);

	/**
	 * 添加处室
	 */
	public int addchushi(Zuzhijigou record);

	/**
	 * 根据处室id删除处室
	 */
	public int deletechushi(int id);

	/**
	 * 更新处室信息
	 */
	public int updatechushi(Zuzhijigou record);
	
	/**
	 * 根据分店id生成处室列表Excel，返回文件路径
	 */
	public String writeexcel(int fdid);

}