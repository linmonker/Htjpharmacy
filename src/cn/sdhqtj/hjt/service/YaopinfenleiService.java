package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Yaopinfenlei;

@Service
public interface YaopinfenleiService {

	// 获取药品分类列表
	public List<Object> Yaopinfenleiquery();
	
	// 根据药品分类id获取药品分类信息
	Yaopinfenlei yaopinfenleiget(Integer id);

	// 添加药品分类
	public Integer yaopinfenleiadd(Yaopinfenlei record);

	// 更新药品分类
	public void yaopinfenleiupdate(Yaopinfenlei record);
	
	// 更新药品分类名称
	public void mingchenupdate(Yaopinfenlei record);

	// 删除药品分类
	public void yaopinfenleidelete(Integer id);

}