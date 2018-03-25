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
	public Keshi keshiget(Integer id);

	/**
	 * 检查重复同一分店一个科室编号和名称
	 */
	public List<Keshi> checkrepeat(Keshi record);

	/**
	 * 添加科室
	 */
	public void keshiadd(Keshi record);

	/**
	 * 根据科室id删除科室
	 */
	public void keshidelete(Integer id);

	/**
	 * 更新科室信息
	 */
	public void keshiupdate(Keshi record);

}