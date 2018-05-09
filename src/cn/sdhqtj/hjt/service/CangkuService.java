package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Cangku;

/**
 * 仓库service接口
 */
@Service
public interface CangkuService {

	/**
	 * 根据分店id获取仓库列表
	 */
	public List<Cangku> cangkuquery(int id);

	/**
	 * 根据分店id获取仓库列表，从start开始20条记录
	 */
	List<Cangku> getlist(int fdid, int start);

	/**
	 * 根据分店id获取仓库列表记录数
	 */
	int getcount(int fdid);

	/**
	 * 模糊搜索仓库：仓库编号，仓库名称，从start开始20条记录
	 */
	List<Cangku> searchcangku(Cangku record, int start);

	/**
	 * 搜索仓库列表记录数
	 */
	int getsearchcount(Cangku record);

	/**
	 * 通过仓库id获取仓库信息
	 */
	public Cangku getcangku(int id);

	/**
	 * 检查重复：仓库编号每个分店唯一
	 */
	List<Cangku> checkrepeat(Cangku record);

	/**
	 * 添加仓库
	 */
	public int addcangku(Cangku record);

	/**
	 * 根据仓库id删除分店
	 */
	public int deletecangku(int id);

	/**
	 * 更新仓库信息，部分字段
	 */
	public int updatecangku(Cangku record);

	/**
	 * 根据分店id生成仓库列表Excel，返回文件路径
	 */
	public String writeexcel(int fdid);

}