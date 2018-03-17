package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;
import cn.sdhqtj.hjt.mapper.YaopinMapper;
import cn.sdhqtj.hjt.mapper.YaopinMapperPro;
import cn.sdhqtj.hjt.service.YaopinService;

@Service
public class YaopinSer implements YaopinService {

	@Resource
	private YaopinMapperPro yaopinMapperPro;
	
	@Resource
	private YaopinMapper yaopinMapper;
	Yaopin yaopintemp;
	YaopinWithBLOBs yaopinBtemp;
	
	@Override
	public List<Yaopin> yaopinquery() {
		// TODO Auto-generated method stub
		List<Yaopin> list = yaopinMapperPro.yaopinquery();
		return list;
	}

	@Override
	public YaopinWithBLOBs yaopinget(Integer id) {
		// TODO Auto-generated method stub
		yaopinBtemp = yaopinMapper.selectByPrimaryKey(id);
		return yaopinBtemp;
	}


	@Override
	public YaopinWithBLOBs selectByypbh(String ypbh) {
		// TODO Auto-generated method stub
		yaopinBtemp = yaopinMapperPro.selectByypbh(ypbh);
		return yaopinBtemp;
	}


	@Override
	public YaopinWithBLOBs selectByypmc(String ypmc) {
		// TODO Auto-generated method stub
		yaopinBtemp = yaopinMapperPro.selectByypmc(ypmc);
		return yaopinBtemp;
	}


	@Override
	public void yaopinadd(YaopinWithBLOBs yaopin) {
		// TODO Auto-generated method stub
		yaopinMapper.insert(yaopin);
		
	}


	@Override
	public void yaopindelete(int id) {
		// TODO Auto-generated method stub
		yaopinMapper.deleteByPrimaryKey(id);
	}


	@Override
	public void yaopinUpdate(YaopinWithBLOBs yaopin) {
		// TODO Auto-generated method stub
		yaopinMapper.updateByPrimaryKeySelective(yaopin);
	}

	

}
