package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.entity.YaopinflNode;

/**
 * 药品分类mapper补充
 */
public interface YaopinfenleiMapperPro {

	/**
	 * 获取药品分类列表
	 */
	List<Yaopinfenlei> Yaopinfenleiquery();

	/**
	 * 获取药品分类节点
	 */
	List<YaopinflNode> getypflnodes();

	/**
	 * 检查重复：药品分类编号
	 */
	List<Yaopinfenlei> checkrepeat(Yaopinfenlei record);

	/**
	 * 添加药品分类，返回id
	 */
	int addyaopinfenlei(Yaopinfenlei record);

	/**
	 * 更新药品分类
	 */
	int updateyaopinfenlei(Yaopinfenlei record);
}