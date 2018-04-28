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
	 * 搜索药品
	 */
	List<YaopinVo> searchyaopin(Yaopin record);

	/**
	 * 检查重复，药品编号
	 */
	List<Yaopin> checkrepeat(String String);

	/**
	 * 更新药品信息
	 */
	void updateyaopin(YaopinWithBLOBs record);

}