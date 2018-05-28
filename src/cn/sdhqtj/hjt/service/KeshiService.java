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
	public List<Keshi> keshiquery(int fdid);

	/**
	 * 根据分店id获取科室列表，从start开始20条记录
	 */
	List<Keshi> getlist(int fdid, int start);

	/**
	 * 根据分店id获取科室列表记录数
	 */
	int getcount(int fdid);

	/**
	 * 模糊搜索科室：科室名称，从start开始20条记录
	 */
	List<Keshi> searchkeshi(Keshi record, int start);

	/**
	 * 搜索科室列表记录数
	 */
	int getsearchcount(Keshi record);

	/**
	 * 根据科室id获取科室信息
	 */
	public Keshi getkeshi(int id);

	/**
	 * 检查重复：科室编号同一分店唯一
	 */
	public List<Keshi> checkrepeat(Keshi record);

	/**
	 * 添加科室
	 */
	public int addkeshi(Keshi record);

	/**
	 * 根据科室id删除科室
	 */
	public int deletekeshi(int id);

	/**
	 * 更新科室信息
	 */
	public int updatekeshi(Keshi record);

	/**
	 * 根据分店id生成科室列表Excel，返回文件路径
	 */
	public String writeexcel(int fdid);

}