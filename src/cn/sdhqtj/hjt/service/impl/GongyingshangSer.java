/**  
* Title: GongyingshangSer.java  
* Description:供应商service实现类  
* @author LIN  
* @date 2018年3月10日  
*/
package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;
import cn.sdhqtj.hjt.mapper.GongyingshangMapper;
import cn.sdhqtj.hjt.mapper.GongyingshangMapperPro;
import cn.sdhqtj.hjt.service.GongyingshangService;

@Service
public class GongyingshangSer implements GongyingshangService {

	@Resource
	private GongyingshangMapperPro gysMapperPro;
	
	@Resource
	private GongyingshangMapper gysMapper;
	Gongyingshang gystemp;
	GongyingshangWithBLOBs gysBtemp;
	List<Gongyingshang> gyslist;
	
	//获取供应商列表
	@Override
	public List<Gongyingshang> gongyingshangquery() {
		// TODO Auto-generated method stub
		gyslist = gysMapperPro.Gongyingshangquery();
		
		return gyslist;
	}

	//通过供应商编号获取供应商信息
	@Override
	public GongyingshangWithBLOBs selectBygysbhWithBLOBs(String gysbh) {
		// TODO Auto-generated method stub
		gysBtemp = gysMapperPro.selectBygysbhWithBLOBs(gysbh);
		return gysBtemp;
	}

	//添加供应商
	@Override
	public void gongyingshangadd(GongyingshangWithBLOBs gysB) {
		// TODO Auto-generated method stub
		gysMapper.insert(gysB);
	}

	//更新供应商
	@Override
	public void gongyingshangupdate(GongyingshangWithBLOBs gysB) {
		// TODO Auto-generated method stub
		gysMapper.updateByPrimaryKeySelective(gysB);
	}

	//根据供应商id删除供应商
	@Override
	public void gongyingshangdelete(Integer id) {
		// TODO Auto-generated method stub
		gysMapper.deleteByPrimaryKey(id);
	}
}
