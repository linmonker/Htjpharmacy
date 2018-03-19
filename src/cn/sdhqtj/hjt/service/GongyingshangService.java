/**  
* Title: GongyingshangSer.java  
* Description:供应商service接口  
* @author LIN  
* @date 2018年3月10日  
*/
package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;

@Service
public interface GongyingshangService {

	//获取供应商列表
	public List<Gongyingshang> gongyingshangquery();

	//通过供应商编号获取供应商信息
	public GongyingshangWithBLOBs selectBygysbhWithBLOBs(String gysbh);

	//添加供应商
	public void gongyingshangadd(GongyingshangWithBLOBs gysB);
	
	//更新供应商
	public void gongyingshangupdate(GongyingshangWithBLOBs gysB);

	//根据供应商id删除供应商
	public void gongyingshangdelete(Integer id);
	
}