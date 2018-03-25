package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Zuzhijigou;
import cn.sdhqtj.hjt.mapper.ZuzhijigouMapper;
import cn.sdhqtj.hjt.mapper.ZuzhijigouMapperPro;
import cn.sdhqtj.hjt.service.ChushiService;

/**
 * 处室service接口实现类
 */
@Service
public class ChushiSer implements ChushiService {

	@Resource
	private ZuzhijigouMapperPro zuzhijigouMapperPro;

	@Resource
	private ZuzhijigouMapper zuzhijigouMapper;
	Zuzhijigou chushi;
	List<Zuzhijigou> chushilist;

	/**
	 * 根据分店id获取处室列表
	 */
	@Override
	public List<Zuzhijigou> chushiquery(Integer id) {
		// TODO Auto-generated method stub
		chushilist = zuzhijigouMapperPro.chushiquery(id);
		return chushilist;
	}

	/**
	 * 根据处室id获取处室信息
	 */
	@Override
	public Zuzhijigou chushiget(Integer id) {
		// TODO Auto-generated method stub
		chushi = zuzhijigouMapper.selectByPrimaryKey(id);
		return chushi;
	}

	/**
	 * 检查重复同一分店一个处室编号和名称
	 */
	@Override
	public List<Zuzhijigou> checkrepeat(Zuzhijigou record) {
		// TODO Auto-generated method stub
		chushilist = zuzhijigouMapperPro.checkrepeat(record);
		return chushilist;
	}

	/**
	 * 添加处室
	 */
	@Override
	public void chushiadd(Zuzhijigou record) {
		// TODO Auto-generated method stub
		try {
			zuzhijigouMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 根据处室id删除处室
	 */
	@Override
	public void chushidelete(Integer id) {
		// TODO Auto-generated method stub
		chushi = new Zuzhijigou();
		chushi.setId(id);
		chushi.setDm(1);
		try {
			zuzhijigouMapper.updateByPrimaryKeySelective(chushi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 更新处室信息
	 */
	@Override
	public void chushiupdate(Zuzhijigou record) {
		// TODO Auto-generated method stub
		try {
			zuzhijigouMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
