package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Huowei;
import cn.sdhqtj.hjt.mapper.HuoweiMapper;
import cn.sdhqtj.hjt.mapper.HuoweiMapperPro;
import cn.sdhqtj.hjt.service.HuoweiService;

/**
 * 货位service接口实现类
 */
@Service
public class HuoweiSer implements HuoweiService {

	@Resource
	private HuoweiMapperPro huoweiMapperPro;

	@Resource
	private HuoweiMapper huoweiMapper;
	Huowei huowei;
	List<Huowei> huoweilist;

	/**
	 * 根据仓库id获取货位列表
	 */
	@Override
	public List<Huowei> huoweiquery(Integer id) {
		// TODO Auto-generated method stub
		huoweilist = huoweiMapperPro.huoweiquery(id);
		return huoweilist;
	}

	/**
	 * 通过货位id获取货位信息
	 */
	@Override
	public Huowei gethuowei(Integer id) {
		// TODO Auto-generated method stub
		huowei = huoweiMapper.selectByPrimaryKey(id);
		return huowei;
	}

	/**
	 * 搜索货位
	 */
	@Override
	public List<Huowei> searchhuowei(Huowei record) {
		// TODO Auto-generated method stub
		huoweilist = huoweiMapperPro.searchhuowei(record);
		return huoweilist;
	}

	/**
	 * 检查重复，货物编号同一仓库唯一
	 */
	@Override
	public List<Huowei> checkrepeat(Huowei record) {
		// TODO Auto-generated method stub
		huoweilist = huoweiMapperPro.checkrepeat(record);
		return huoweilist;
	}

	/**
	 * 添加货位
	 */
	@Override
	public void addhuowei(Huowei record) {
		// TODO Auto-generated method stub
		try {
			huoweiMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据货位id删除货位
	 */
	@Override
	public void deletehuowei(Integer id) {
		// TODO Auto-generated method stub
		huowei = new Huowei();
		huowei.setId(id);
		huowei.setDm(1);
		try {
			huoweiMapper.updateByPrimaryKeySelective(huowei);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 更新货位信息
	 */
	@Override
	public void updatehuowei(Huowei record) {
		// TODO Auto-generated method stub
		try {
			huoweiMapperPro.updatehuowei(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
