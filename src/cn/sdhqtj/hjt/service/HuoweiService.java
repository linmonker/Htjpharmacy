package cn.sdhqtj.hjt.service;

import java.util.List;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Huowei;

/**
 * 货位service接口
 */
@Service
public interface HuoweiService {

	/**
	 * 根据仓库id获取货位列表
	 */
	public List<Huowei> huoweiquery(Integer id);

	/**
	 * 通过货位id获取货位信息
	 */
	public Huowei gethuowei(Integer id);

	/**
	 * 检查重复，货物编号同一仓库唯一
	 */
	public Huowei checkrepeat(Huowei record);

	/**
	 * 添加货位
	 */
	public void addhuowei(Huowei record);

	/**
	 * 根据货位id删除货位
	 */
	public void deletehuowei(Integer id);

	/**
	 * 更新货位信息
	 */
	public void updatehuowei(Huowei record);

}