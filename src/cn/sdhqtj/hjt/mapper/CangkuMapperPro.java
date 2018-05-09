package cn.sdhqtj.hjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sdhqtj.hjt.entity.Cangku;
import cn.sdhqtj.hjt.entity.CangkuVo;

/**
 * 仓库mapper补充
 */
public interface CangkuMapperPro {

	/**
	 * 根据分店id获取仓库列表
	 */
	List<Cangku> cangkuquery(@Param("fdid") int fdid);
	
	/**
	 * 根据分店id获取仓库列表，从start开始20条记录
	 */
	List<Cangku> getlist(@Param("fdid") int fdid, @Param("start") int start);

	/**
	 * 根据分店id获取仓库列表记录数
	 */
	int getcount(@Param("fdid") int fdid);

	/**
	 * 模糊搜索仓库：仓库编号，仓库名称，从start开始20条记录
	 */
	List<Cangku> searchcangku(@Param("cangku") Cangku record, @Param("start") int start);

	/**
	 * 搜索仓库列表记录数
	 */
	int getsearchcount(@Param("cangku") Cangku record);

	/**
	 * 根据分店id获取仓库Excel列表
	 */
	List<CangkuVo> getexcellist(int fdid);

	/**
	 * 检查重复：仓库编号每个分店唯一
	 */
	List<Cangku> checkrepeat(Cangku record);

	/**
	 * 更新仓库信息，部分字段
	 */
	int updatecangku(Cangku record);
}