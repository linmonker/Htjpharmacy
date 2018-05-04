package cn.sdhqtj.hjt.mapper;

import java.util.List;

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
	 * 根据分店id获取科室Excel列表
	 */
	List<KeshiVo> getexcellist(int fdid);
	
	/**
	 * 模糊搜索科室：科室名称
	 */
	List<Keshi> searchkeshi(Keshi record);

	/**
	 * 检查重复：科室编号同一分店唯一
	 */
	List<Keshi> checkrepeat(Keshi record);

	/**
	 * 更新科室信息
	 */
	int updatekeshi(Keshi record);

}