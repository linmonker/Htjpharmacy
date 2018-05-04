package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.entity.YaopinfenleiNode;

/**
 * 药品分类service接口
 */
@Service
public interface YaopinfenleiService {

	/**
	 * 获取药品分类列表
	 */
	public List<Yaopinfenlei> Yaopinfenleiquery();

	/**
	 * 获取药品分类节点
	 */
	List<YaopinfenleiNode> getypflnodes();

	/**
	 * 检查重复：药品分类编号
	 */
	List<Yaopinfenlei> checkrepeat(Yaopinfenlei record);

	/**
	 * 根据药品分类id获取药品分类信息
	 */
	Yaopinfenlei getyaopinfenlei(int id);

	/**
	 * 添加药品分类，添加药品分类，返回id
	 */
	public int addyaopinfenlei(Yaopinfenlei record);

	/**
	 * 更新药品分类
	 */
	public int updateyaopinfenlei(Yaopinfenlei record);

	/**
	 * 更新药品分类名称
	 */
	public int updatemingchen(Yaopinfenlei record);

	/**
	 * 删除药品分类
	 */
	public int deleteyaopinfenlei(int id);
	
	/**
	 * 生成药品分类列表Excel，返回文件路径
	 */
	public String writeexcel();

}