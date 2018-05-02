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
	public List<Cangku> cangkuquery(int id) {
		// TODO Auto-generated method stub
		cangkulist = cangkuMapperPro.cangkuquery(id);
		return cangkulist;
	}

	/**
	 * 通过仓库id获取仓库信息
	 */
	@Override
	public Cangku getcangku(int id) {
		// TODO Auto-generated method stub
		cangku = cangkuMapper.selectByPrimaryKey(id);
		return cangku;
	}

	/**
	 * 模糊搜索仓库：仓库编号，仓库名称
	 */
	@Override
	public List<Cangku> searchcangku(Cangku record) {
		// TODO Auto-generated method stub
		cangkulist = cangkuMapperPro.searchcangku(record);
		return cangkulist;
	}

	/**
	 * 检查重复：仓库编号每个分店唯一
	 */
	@Override
	public List<Cangku> checkrepeat(Cangku record) {
		// TODO Auto-generated method stub
		// 如果id为null，则设置id=-1，与数据库所有记录比较
		if (record.getId() == null) {
			record.setId(-1);
		}
		cangkulist = cangkuMapperPro.checkrepeat(record);
		return cangkulist;
	}

	/**
	 * 添加仓库
	 */
	@Override
	public int addcangku(Cangku record) {
		// TODO Auto-generated method stub
		try {
			return cangkuMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据仓库id删除仓库
	 */
	@Override
	public int deletecangku(int id) {
		// TODO Auto-generated method stub
		cangku = new Cangku();
		cangku.setId(id);
		cangku.setDm(1);
		try {
			return cangkuMapper.updateByPrimaryKeySelective(cangku);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新仓库信息，部分字段
	 */
	@Override
	public int updatecangku(Cangku record) {
		// TODO Auto-generated method stub
		try {
			return cangkuMapperPro.updatecangku(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

}
