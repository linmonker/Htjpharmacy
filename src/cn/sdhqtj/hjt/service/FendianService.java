/**  
* Title: FendianSer.java  
* Description:分店service接口  
* @author LIN  
* @date 2018年3月10日  
*/
package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Fendian;

@Service
public interface FendianService {

	//获取分店列表
	public List<Fendian> fendianquery();

	//通过分店id获取分店信息
	public Fendian fendianget(Integer id);

	//通过分店编号获取分店信息
	public Fendian selectByfdbh(String fdbh);

	//通过分店名称获取分店信息
	public Fendian selectByfdmc(String fdmc);

	//添加分店
	public void fendianadd(Fendian fendian);

	//根据分店id删除分店
	public void fendiandelete(int id);

	//更新分店信息
	public void fendianUpdate(Fendian fendian);

}