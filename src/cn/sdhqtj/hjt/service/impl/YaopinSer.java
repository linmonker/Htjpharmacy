package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinVo;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;
import cn.sdhqtj.hjt.mapper.YaopinMapper;
import cn.sdhqtj.hjt.mapper.YaopinMapperPro;
import cn.sdhqtj.hjt.service.YaopinService;

/**
 * 药品service接口实现类
 */
@Service
public class YaopinSer implements YaopinService {

	@Resource
	private YaopinMapperPro yaopinMapperPro;

	@Resource
	private YaopinMapper yaopinMapper;
	Yaopin yaopin;
	List<Yaopin> yaopinlist;
	YaopinWithBLOBs yaopinB;
	List<YaopinVo> yaopinvolist;

	/**
	 * 获取药品列表
	 */
	@Override
	public List<YaopinVo> yaopinquery() {
		// TODO Auto-generated method stub
		yaopinvolist = yaopinMapperPro.yaopinquery();
		return yaopinvolist;
	}

	/**
	 * 根据药品id获取药品信息
	 */
	@Override
	public YaopinWithBLOBs getyaopin(int id) {
		// TODO Auto-generated method stub
		yaopinB = yaopinMapper.selectByPrimaryKey(id);
		return yaopinB;
	}

	/**
	 * 模糊搜索药品：药品编号，药品商品名，药品通用名
	 */
	@Override
	public List<YaopinVo> searchyaopin(Yaopin record) {
		// TODO Auto-generated method stub
		yaopinvolist = yaopinMapperPro.searchyaopin(record);
		return yaopinvolist;
	}

	/**
	 * 检查重复：药品编号
	 */
	@Override
	public List<Yaopin> checkrepeat(YaopinWithBLOBs record) {
		// TODO Auto-generated method stub
		// 如果id为null，则设置id=-1，与数据库所有记录比较
		if (record.getId() == null) {
			record.setId(-1);
		}
		yaopinlist = yaopinMapperPro.checkrepeat(record);
		return yaopinlist;
	}

	/**
	 * 添加药品
	 */
	@Override
	public int addyaopin(YaopinWithBLOBs record) {
		// TODO Auto-generated method stub
		try {
			return yaopinMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据药品id删除药品
	 */
	@Override
	public int deleteyaopin(int id) {
		// TODO Auto-generated method stub
		yaopinB = new YaopinWithBLOBs();
		yaopinB.setId(id);
		yaopinB.setDm(1);
		try {
			return yaopinMapper.updateByPrimaryKeySelective(yaopinB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新药品信息
	 */
	@Override
	public int updateyaopin(YaopinWithBLOBs record) {
		// TODO Auto-generated method stub
		try {
			return yaopinMapperPro.updateyaopin(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

}
