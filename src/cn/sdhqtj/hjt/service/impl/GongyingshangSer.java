package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;
import cn.sdhqtj.hjt.mapper.GongyingshangMapper;
import cn.sdhqtj.hjt.mapper.GongyingshangMapperPro;
import cn.sdhqtj.hjt.service.GongyingshangService;

/**
 * 供应商service接口实现类
 */
@Service
public class GongyingshangSer implements GongyingshangService {

	@Resource
	private GongyingshangMapperPro gysMapperPro;

	@Resource
	private GongyingshangMapper gysMapper;
	Gongyingshang gys;
	GongyingshangWithBLOBs gysB;
	List<Gongyingshang> gyslist;

	/**
	 * 获取供应商列表
	 */
	@Override
	public List<Gongyingshang> gongyingshangquery() {
		// TODO Auto-generated method stub
		gyslist = gysMapperPro.gongyingshangquery();
		return gyslist;
	}

	/**
	 * 根据分店id获取供应商列表
	 */
	@Override
	public List<Gongyingshang> getquerybyfdid(int fdid) {
		// TODO Auto-generated method stub
		gyslist = gysMapperPro.getquerybyfdid(fdid);
		return gyslist;
	}

	/**
	 * 通过供应商id获取供应商信息
	 */
	@Override
	public GongyingshangWithBLOBs getgongyingshang(int id) {
		// TODO Auto-generated method stub
		gysB = gysMapper.selectByPrimaryKey(id);
		return gysB;
	}

	/**
	 * 模糊搜索供应商：供应商编号，供应商名称
	 */
	@Override
	public List<Gongyingshang> searchgongyingshang(Gongyingshang record) {
		// TODO Auto-generated method stub
		gyslist = gysMapperPro.searchgongyingshang(record);
		return gyslist;
	}

	/**
	 * 检查重复：供应商编号
	 */
	@Override
	public List<Gongyingshang> checkrepeat(Gongyingshang record) {
		// TODO Auto-generated method stub
		// 如果id为null，则设置id=-1，与数据库所有记录比较
		if (record.getId() == null) {
			record.setId(-1);
		}
		gyslist = gysMapperPro.checkrepeat(record);
		return gyslist;
	}

	/**
	 * 添加供应商
	 */
	@Override
	public int addgongyingshang(GongyingshangWithBLOBs record) {
		// TODO Auto-generated method stub
		try {
			return gysMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新供应商
	 */
	@Override
	public int updategongyingshang(GongyingshangWithBLOBs record) {
		// TODO Auto-generated method stub
		try {
			return gysMapperPro.updategongyingshang(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据供应商id删除供应商
	 */
	@Override
	public int deletegongyingshang(int id) {
		// TODO Auto-generated method stub
		gysB = new GongyingshangWithBLOBs();
		gysB.setId(id);
		gysB.setDm(1);
		try {
			return gysMapper.updateByPrimaryKeySelective(gysB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}
}
