package cn.sdhqtj.hjt.service;

import java.util.List;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Keshi;

/**
 * 处室service接口
 */
@Service
public interface KeshiService {

	/**
	 * 根据分店id获取科室列表
	 */
	public List<Keshi> keshiquery(Integer id);

	/**
	 * 根据科室id获取科室信息
	 */
	public Keshi getkeshi(Integer id);
	
	/**
	 * 搜索科室
	 */
	List<Keshi> searchkeshi(Keshi record);

	/**
	 * 检查重复检查重复，科室编号同一分店唯一
	 */
	public List<Keshi> checkrepeat(Keshi record);

	/**
	 * 添加科室
	 */
	public void addkeshi(Keshi record);

	/**
	 * 根据科室id删除科室
	 */
	public void deletekeshi(Integer id);

	/**
	 * 更新科室信息
	 */
	public void updatekeshi(Keshi record);

}