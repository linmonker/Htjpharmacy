package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Fendian;
import cn.sdhqtj.hjt.mapper.FendianMapper;
import cn.sdhqtj.hjt.mapper.FendianMapperPro;
import cn.sdhqtj.hjt.service.FendianService;

/**
 * 分店service接口实现类
 */
@Service
public class FendianSer implements FendianService {

	@Resource
	private FendianMapperPro fendianMapperPro;

	@Resource
	private FendianMapper fendianMapper;
	Fendian fendian;
	List<Fendian> fendianlist;

	/**
	 * 获取分店列表
	 */
	@Override
	public List<Fendian> fendianquery() {
		// TODO Auto-generated method stub
		fendianlist = fendianMapperPro.fendianquery();
		return fendianlist;
	}

	/**
	 * 通过分店id获取分店信息
	 */
	@Override
	public Fendian fendianget(Integer id) {
		// TODO Auto-generated method stub
		fendian = fendianMapper.selectByPrimaryKey(id);
		return fendian;
	}

	/**
	 * 检查重复，分店编号和分店名称
	 */
	@Override
	public List<Fendian> checkrepeat(Fendian record) {
		// TODO Auto-generated method stub
		fendianlist = fendianMapperPro.checkrepeat(record);
		return fendianlist;
	}

	/**
	 * 添加分店
	 */
	@Override
	public void fendianadd(Fendian record) {
		// TODO Auto-generated method stub
		try {
			fendianMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据分店id删除分店
	 */
	@Override
	public void fendiandelete(Integer id) {
		// TODO Auto-generated method stub
		fendian = new Fendian();
		fendian.setId(id);
		fendian.setZt(1);
		try {
			fendianMapper.updateByPrimaryKeySelective(fendian);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 更新分店信息
	 */
	@Override
	public void fendianupdate(Fendian record) {
		// TODO Auto-generated method stub
		try {
			fendianMapperPro.fendianupdate(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
