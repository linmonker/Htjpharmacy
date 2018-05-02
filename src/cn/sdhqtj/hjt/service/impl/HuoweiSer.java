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
	public List<Huowei> huoweiquery(int id) {
		// TODO Auto-generated method stub
		huoweilist = huoweiMapperPro.huoweiquery(id);
		return huoweilist;
	}

	/**
	 * 通过货位id获取货位信息
	 */
	@Override
	public Huowei gethuowei(int id) {
		// TODO Auto-generated method stub
		huowei = huoweiMapper.selectByPrimaryKey(id);
		return huowei;
	}

	/**
	 * 模糊搜索货位：货位名称
	 */
	@Override
	public List<Huowei> searchhuowei(Huowei record) {
		// TODO Auto-generated method stub
		huoweilist = huoweiMapperPro.searchhuowei(record);
		return huoweilist;
	}

	/**
	 * 检查重复：货物编号同一仓库唯一
	 */
	@Override
	public List<Huowei> checkrepeat(Huowei record) {
		// TODO Auto-generated method stub
		// 如果id为null，则设置id=-1，与数据库所有记录比较
		if (record.getId() == null) {
			record.setId(-1);
		}
		huoweilist = huoweiMapperPro.checkrepeat(record);
		return huoweilist;
	}

	/**
	 * 添加货位
	 */
	@Override
	public int addhuowei(Huowei record) {
		// TODO Auto-generated method stub
		try {
			return huoweiMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据货位id删除货位
	 */
	@Override
	public int deletehuowei(int id) {
		// TODO Auto-generated method stub
		huowei = new Huowei();
		huowei.setId(id);
		huowei.setDm(1);
		try {
			return huoweiMapper.updateByPrimaryKeySelective(huowei);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新货位信息
	 */
	@Override
	public int updatehuowei(Huowei record) {
		// TODO Auto-generated method stub
		try {
			return huoweiMapperPro.updatehuowei(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

}
