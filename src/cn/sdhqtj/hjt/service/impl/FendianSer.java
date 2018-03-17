package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Fendian;
import cn.sdhqtj.hjt.mapper.FendianMapper;
import cn.sdhqtj.hjt.mapper.FendianMapperPro;
import cn.sdhqtj.hjt.service.FendianService;

@Service
public class FendianSer implements FendianService {

	@Resource
	private FendianMapperPro fendianMapperPro;
	
	@Resource
	private FendianMapper fendianMapper;
	Fendian fendiantemp;

	@Override
	public List<Fendian> fendianquery() {
		// TODO Auto-generated method stub
		List<Fendian> list = fendianMapperPro.fendianquery();
		return list;
	}

	@Override
	public Fendian fendianget(Integer id) {
		// TODO Auto-generated method stub
		fendiantemp = fendianMapper.selectByPrimaryKey(id);
		return fendiantemp;
	}
	
	@Override
	public Fendian selectByfdbh(String fdbh) {
		// TODO Auto-generated method stub
		fendiantemp = fendianMapperPro.selectByfdbh(fdbh);
		return fendiantemp;
	}

	@Override
	public Fendian selectByfdmc(String fdmc) {
		// TODO Auto-generated method stub
		fendiantemp = fendianMapperPro.selectByfdmc(fdmc);
		return fendiantemp;
	}

	@Override
	public void fendianadd(Fendian fendian) {
		// TODO Auto-generated method stub
		fendianMapper.insertSelective(fendian);
	}

	@Override
	public void fendiandelete(int id) {
		// TODO Auto-generated method stub
		fendiantemp = fendianMapper.selectByPrimaryKey(id);
		if(fendiantemp != null) {
			fendianMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void fendianUpdate(Fendian fendian) {
		// TODO Auto-generated method stub
		fendianMapper.updateByPrimaryKeySelective(fendian);
	}

	

}
