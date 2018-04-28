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
	 * 通过供应商id获取供应商信息
	 */
	@Override
	public GongyingshangWithBLOBs getgongyingshang(Integer id) {
		// TODO Auto-generated method stub
		gysB = gysMapper.selectByPrimaryKey(id);
		return gysB;
	}

	/**
	 *
	 */
	@Override
	public List<Gongyingshang> searchgongyingshang(Gongyingshang record) {
		// TODO Auto-generated method stub
		gyslist = gysMapperPro.searchgongyingshang(record);
		return gyslist;
	}

	/**
	 * 检查重复，供应商编号
	 */
	@Override
	public List<Gongyingshang> checkrepeat(Gongyingshang record) {
		// TODO Auto-generated method stub
		gyslist = gysMapperPro.checkrepeat(record);
		return gyslist;
	}

	/**
	 * 添加供应商
	 */
	@Override
	public void addgongyingshang(GongyingshangWithBLOBs record) {
		// TODO Auto-generated method stub
		try {
			gysMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 更新供应商
	 */
	@Override
	public void updategongyingshang(GongyingshangWithBLOBs record) {
		// TODO Auto-generated method stub
		try {
			gysMapperPro.updategongyingshang(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据供应商id删除供应商
	 */
	@Override
	public void deletegongyingshang(Integer id) {
		// TODO Auto-generated method stub
		gysB = new GongyingshangWithBLOBs();
		gysB.setId(id);
		gysB.setDm(1);
		try {
			gysMapper.updateByPrimaryKeySelective(gysB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
