package cn.sdhqtj.hjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinVo;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;

/**
 * 药品mapper补充
 */
public interface YaopinMapperPro {

	/**
	 * 获取药品列表
	 */
	List<YaopinVo> yaopinquery();

	/**
	 * 获取药品列表，从start开始20条记录
	 */
	List<YaopinVo> getlist(@Param("start") int start);

	/**
	 * 获取药品列表记录数
	 */
	int getcount();

	/**
	 * 模糊搜索药品：药品编号，药品商品名，药品通用名，从start开始20条记录
	 */
	List<YaopinVo> searchyaopin(@Param("yaopin") Yaopin record, @Param("start") int start);

	/**
	 * 搜索药品列表记录数
	 */
	int getsearchcount(@Param("yaopin") Yaopin record);

	/**
	 * 获取药品Excel列表
	 */
	List<YaopinVo> getexcellist();

	/**
	 * 检查重复：药品编号
	 */
	List<Yaopin> checkrepeat(YaopinWithBLOBs record);

	/**
	 * 更新药品信息
	 */
	int updateyaopin(YaopinWithBLOBs record);

}