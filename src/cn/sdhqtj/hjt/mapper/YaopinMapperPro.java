package cn.sdhqtj.hjt.mapper;

import java.util.List;

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
	 * 获取药品Excel列表
	 */
	List<YaopinVo> getexcellist();
	
	/**
	 * 模糊搜索药品：药品编号，药品商品名，药品通用名
	 */
	List<YaopinVo> searchyaopin(Yaopin record);

	/**
	 * 检查重复：药品编号
	 */
	List<Yaopin> checkrepeat(YaopinWithBLOBs record);

	/**
	 * 更新药品信息
	 */
	int updateyaopin(YaopinWithBLOBs record);

}