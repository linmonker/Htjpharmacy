package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Keshi;
import cn.sdhqtj.hjt.mapper.KeshiMapper;
import cn.sdhqtj.hjt.mapper.KeshiMapperPro;
import cn.sdhqtj.hjt.service.KeshiService;

/**
 * 科室service接口实现类
 */
@Service
public class KeshiSer implements KeshiService {

	@Resource
	private KeshiMapperPro keshiMapperPro;

	@Resource
	private KeshiMapper keshiMapper;
	Keshi keshi;
	List<Keshi> keshilist;

	/**
	 * 根据分店id获取科室列表
	 */
	@Override
	public List<Keshi> keshiquery(Integer id) {
		// TODO Auto-generated method stub
		keshilist = keshiMapperPro.keshiquery(id);
		return keshilist;
	}

	/**
	 * 根据科室id获取科室信息
	 */
	@Override
	public Keshi keshiget(Integer id) {
		// TODO Auto-generated method stub
		keshi = keshiMapper.selectByPrimaryKey(id);
		return keshi;
	}

	/**
	 * 检查重复同一分店一个科室编号和名称
	 */
	@Override
	public List<Keshi> checkrepeat(Keshi record) {
		// TODO Auto-generated method stub
		keshilist = keshiMapperPro.checkrepeat(record);
		return keshilist;
	}
	
	/**
	 * 添加科室
	 */
	@Override
	public void keshiadd(Keshi record) {
		// TODO Auto-generated method stub
		try {
			keshiMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 根据科室id删除科室
	 */
	@Override
	public void keshidelete(Integer id) {
		// TODO Auto-generated method stub
		keshi = new Keshi();
		keshi.setId(id);
		keshi.setDm(1);
		try {
			keshiMapper.updateByPrimaryKeySelective(keshi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 更新科室信息
	 */
	@Override
	public void keshiupdate(Keshi record) {
		// TODO Auto-generated method stub
		try {
			keshiMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
