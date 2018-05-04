package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Zuzhijigou;
import cn.sdhqtj.hjt.entity.ZuzhijigouVo;

/**
 * 处室mapper补充
 */
public interface ZuzhijigouMapperPro {
	/**
	 * 根据分店id获取处室Excel列表
	 */
	List<ZuzhijigouVo> getexcellist(int fdid);
	
	/**
	 * 根据分店id获取处室列表
	 */
	List<Zuzhijigou> chushiquery(int fdid);
	
	/**
	 * 模糊搜索处室：处室名称
	 */
	List<Zuzhijigou> searchchushi(Zuzhijigou record);
	
	/**
	 * 检查重复：处室编号同一分店唯一
	 */
	List<Zuzhijigou> checkrepeat(Zuzhijigou record);

	/**
	 * 更新处室信息
	 */
	int updatechushi(Zuzhijigou record);
}