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
	public List<Zuzhijigou> chushiquery(Integer id);

	/**
	 * 根据处室id获取处室信息
	 */
	public Zuzhijigou getchushi(Integer id);

	/**
	 * 检查重复，处室编号同一分店唯一
	 */
	public List<Zuzhijigou> checkrepeat(Zuzhijigou record);

	/**
	 * 添加处室
	 */
	public void addchushi(Zuzhijigou record);

	/**
	 * 根据处室id删除处室
	 */
	public void deletechushi(Integer id);

	/**
	 * 更新处室信息
	 */
	public void updatechushi(Zuzhijigou record);

}