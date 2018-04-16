package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinPro;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;

/**
 * 药品mapper补充
 */
public interface YaopinMapperPro {

	/**
	 * 获取药品列表
	 */
	List<YaopinPro> yaopinquery();

	/**
	 * 检查重复，药品编号
	 */
	Yaopin checkrepeat(String record);

	/**
	 * 更新药品信息
	 */
	void updateyaopin(YaopinWithBLOBs record);

}