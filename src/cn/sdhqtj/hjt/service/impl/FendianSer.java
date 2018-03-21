/**  
* Title: FendianSer.java  
* Description:分店service实现类  
* @author LIN  
* @date 2018年3月10日  
*/
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

	// 获取分店列表
	@Override
	public List<Fendian> fendianquery() {
		// TODO Auto-generated method stub
		List<Fendian> list = fendianMapperPro.fendianquery();
		return list;
	}

	// 通过分店id获取分店信息
	@Override
	public Fendian fendianget(Integer id) {
		// TODO Auto-generated method stub
		fendiantemp = fendianMapper.selectByPrimaryKey(id);
		return fendiantemp;
	}

	// 通过分店编号获取分店信息
	@Override
	public Fendian selectByfdbh(String fdbh) {
		// TODO Auto-generated method stub
		fendiantemp = fendianMapperPro.selectByfdbh(fdbh);
		return fendiantemp;
	}

	// 通过分店名称获取分店信息
	@Override
	public Fendian selectByfdmc(String fdmc) {
		// TODO Auto-generated method stub
		fendiantemp = fendianMapperPro.selectByfdmc(fdmc);
		return fendiantemp;
	}

	// 添加分店
	@Override
	public void fendianadd(Fendian fendian) {
		// TODO Auto-generated method stub
		fendianMapper.insertSelective(fendian);
	}

	// 根据分店id删除分店
	@Override
	public void fendiandelete(int id) {
		// TODO Auto-generated method stub
		fendiantemp = fendianMapper.selectByPrimaryKey(id);
		if (fendiantemp != null) {
			try {
				fendianMapper.deleteByPrimaryKey(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 更新分店信息
	@Override
	public void fendianUpdate(Fendian fendian) {
		// TODO Auto-generated method stub
		try {
			fendianMapper.updateByPrimaryKeySelective(fendian);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
