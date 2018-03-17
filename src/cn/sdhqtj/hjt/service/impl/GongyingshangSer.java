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
	
	@Override
	public List<Gongyingshang> gongyingshangquery() {
		// TODO Auto-generated method stub
		gyslist = gysMapperPro.Gongyingshangquery();
		
		return gyslist;
	}

	@Override
	public GongyingshangWithBLOBs selectBygysbhWithBLOBs(String gysbh) {
		// TODO Auto-generated method stub
		gysBtemp = gysMapperPro.selectBygysbhWithBLOBs(gysbh);
		return gysBtemp;
	}

	@Override
	public void gongyingshangadd(GongyingshangWithBLOBs gysB) {
		// TODO Auto-generated method stub
		gysMapper.insert(gysB);
	}

	@Override
	public void gongyingshangupdate(GongyingshangWithBLOBs gysB) {
		// TODO Auto-generated method stub
		gysMapper.updateByPrimaryKeySelective(gysB);
	}

	@Override
	public void gongyingshangdelete(Integer id) {
		// TODO Auto-generated method stub
		gysMapper.deleteByPrimaryKey(id);
	}


}
