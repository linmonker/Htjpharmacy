package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Cangku;
import cn.sdhqtj.hjt.mapper.CangkuMapper;
import cn.sdhqtj.hjt.mapper.CangkuMapperPro;
import cn.sdhqtj.hjt.service.CangkuService;

/**
 * 仓库service接口实现类
 */
@Service
public class CangkuSer implements CangkuService {

	@Resource
	private CangkuMapperPro cangkuMapperPro;

	@Resource
	private CangkuMapper cangkuMapper;
	Cangku cangku;
	List<Cangku> cangkulist;
	
	/**
	 * 根据分店id获取仓库列表
	 */
	@Override
	public List<Cangku> cangkuquery(Integer id) {
		// TODO Auto-generated method stub
		cangkulist = cangkuMapperPro.cangkuquery(id);
		return cangkulist;
	}
	
	/**
	 * 通过仓库id获取仓库信息
	 */
	@Override
	public Cangku getcangku(Integer id) {
		// TODO Auto-generated method stub
		cangku = cangkuMapper.selectByPrimaryKey(id);
		return cangku;
	}
	
	/**
	 *
	 */
	@Override
	public Cangku checkrepeat(Cangku record) {
		// TODO Auto-generated method stub
		cangku = cangkuMapperPro.checkrepeat(record);
		return null;
	}

	/**
	 * 添加仓库
	 */
	@Override
	public void addcangku(Cangku record) {
		// TODO Auto-generated method stub
		try {
			cangkuMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据仓库id删除仓库
	 */
	@Override
	public void deletecangku(Integer id) {
		// TODO Auto-generated method stub
		cangku = new Cangku();
		cangku.setId(id);
		cangku.setDm(1);
		try {
			cangkuMapper.updateByPrimaryKeySelective(cangku);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新仓库信息
	 */
	@Override
	public void updatecangku(Cangku record) {
		// TODO Auto-generated method stub
		try {
			cangkuMapperPro.updatecangku(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
