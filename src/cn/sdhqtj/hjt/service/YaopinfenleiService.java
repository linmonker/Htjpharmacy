package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.entity.YaopinflNode;

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
	List<YaopinflNode> getypflnodes();

	/**
	 * 获取药品分类json列表
	 */
	public List<Object> gettreelist();
	
	/**
	 *检查重复，药品分类编号
	 */
	Yaopinfenlei checkrepeat(Yaopinfenlei record);

	/**
	 * 根据药品分类id获取药品分类信息
	 */
	Yaopinfenlei getyaopinfenlei(Integer id);

	/**
	 * 添加药品分类
	 */
	public Integer addyaopinfenlei(Yaopinfenlei record);

	/**
	 * 更新药品分类
	 */
	public void updateyaopinfenlei(Yaopinfenlei record);

	/**
	 * 更新药品分类名称
	 */
	public void updatemingchen(Yaopinfenlei record);

	/**
	 * 删除药品分类
	 */
	public void deleteyaopinfenlei(Integer id);

}