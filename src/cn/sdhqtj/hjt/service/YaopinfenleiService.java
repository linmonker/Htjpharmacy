/**  
* Title: YaopinfenleiSer.java  
* Description:药品分类service实现类  
* @author LIN  
* @date 2018年3月10日  
*/
package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.entity.YaopinflNode;

@Service
public interface YaopinfenleiService {

	//获取药品分类列表
	public List<Object> Yaopinfenleiquery();

	//添加药品分类
	public Integer yaopinfenleiadd(Yaopinfenlei ypfl);
	
	//更新药品分类
	public void yaopinfenleiupdate(Yaopinfenlei ypfl);

	//删除药品分类
	public void yaopinfenleidelete(Integer id);
	
}