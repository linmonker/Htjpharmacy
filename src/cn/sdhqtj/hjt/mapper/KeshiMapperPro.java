package cn.sdhqtj.hjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sdhqtj.hjt.entity.Keshi;
import cn.sdhqtj.hjt.entity.KeshiVo;

/**
 * 科室mapper补充
 */
public interface KeshiMapperPro {

	/**
	 * 根据分店id获取科室列表
	 */
	List<Keshi> keshiquery(int fdid);
	
	/**
	 * 根据分店id获取科室列表，从start开始20条记录
	 */
	List<Keshi> getlist(@Param("fdid") int fdid, @Param("start") int start);

	/**
	 * 根据分店id获取科室列表记录数
	 */
	int getcount(@Param("fdid") int fdid);

	/**
	 * 模糊搜索科室：科室名称，从start开始20条记录
	 */
	List<Keshi> searchkeshi(@Param("keshi") Keshi record, @Param("start") int start);

	/**
	 * 搜索科室列表记录数
	 */
	int getsearchcount(@Param("keshi") Keshi record);
	
	/**
	 * 根据分店id获取科室Excel列表
	 */
	List<KeshiVo> getexcellist(int fdid);

	/**
	 * 检查重复：科室编号同一分店唯一
	 */
	List<Keshi> checkrepeat(Keshi record);

	/**
	 * 更新科室信息
	 */
	int updatekeshi(Keshi record);

}