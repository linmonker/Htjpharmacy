/**  
* Title: YaopinfenleiSer.java  
* Description:药品service接口 
* @author LIN  
* @date 2018年3月10日  
*/
package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;

@Service
public interface YaopinService {

	//获取药品列表
	public List<Yaopin> yaopinquery();

	//根据药品id获取药品信息
	public YaopinWithBLOBs yaopinget(Integer id);

	//根据药品编号获取药品信息
	public YaopinWithBLOBs selectByypbh(String ypbh);

	//添加药品
	public void yaopinadd(YaopinWithBLOBs yaopin);

	//根据药品id删除药品
	public void yaopindelete(int id);

	//更新药品
	public void yaopinUpdate(YaopinWithBLOBs yaopin);

}