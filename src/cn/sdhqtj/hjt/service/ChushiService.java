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
	public Zuzhijigou chushiget(Integer id);

	/**
	 * 检查重复同一分店一个处室编号和名称
	 */
	public List<Zuzhijigou> checkrepeat(Zuzhijigou record);

	/**
	 * 添加处室
	 */
	public void chushiadd(Zuzhijigou record);

	/**
	 * 根据处室id删除处室
	 */
	public void chushidelete(Integer id);

	/**
	 * 更新处室信息
	 */
	public void chushiupdate(Zuzhijigou record);

}