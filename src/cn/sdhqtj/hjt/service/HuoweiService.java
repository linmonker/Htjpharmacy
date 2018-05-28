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
	public List<Huowei> huoweiquery(int ckid);

	/**
	 * 根据仓库id获取货位列表，从start开始20条记录
	 */
	List<Huowei> getlist(int ckid, int start);

	/**
	 * 根据仓库id获取货位列表记录数
	 */
	int getcount(int ckid);

	/**
	 * 模糊搜索货位：货位名称，从start开始20条记录
	 */
	List<Huowei> searchhuowei(Huowei record, int start);

	/**
	 * 搜索仓库列表记录数
	 */
	int getsearchcount(Huowei record);

	/**
	 * 通过货位id获取货位信息
	 */
	public Huowei gethuowei(int id);

	/**
	 * 检查重复：货物编号同一仓库唯一
	 */
	public List<Huowei> checkrepeat(Huowei record);

	/**
	 * 添加货位
	 */
	public int addhuowei(Huowei record);

	/**
	 * 根据货位id删除货位
	 */
	public int deletehuowei(int id);

	/**
	 * 更新货位信息，部分字段
	 */
	public int updatehuowei(Huowei record);

	/**
	 * 根据仓库id生成货位列表Excel，返回文件路径
	 */
	public String writeexcel(int ckid);

}