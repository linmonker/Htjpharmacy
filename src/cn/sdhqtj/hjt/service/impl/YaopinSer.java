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
	public YaopinWithBLOBs getyaopin(Integer id) {
		// TODO Auto-generated method stub
		yaopinB = yaopinMapper.selectByPrimaryKey(id);
		return yaopinB;
	}

	/**
	 * 搜索药品
	 */
	@Override
	public List<YaopinVo> searchyaopin(Yaopin record) {
		// TODO Auto-generated method stub
		yaopinvolist = yaopinMapperPro.searchyaopin(record);
		return yaopinvolist;
	}

	/**
	 * 检查重复，药品编号
	 */
	@Override
	public List<Yaopin> checkrepeat(String string) {
		// TODO Auto-generated method stub
		yaopinlist = yaopinMapperPro.checkrepeat(string);
		return yaopinlist;
	}

	/**
	 * 添加药品
	 */
	@Override
	public void addyaopin(YaopinWithBLOBs record) {
		// TODO Auto-generated method stub
		try {
			yaopinMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 根据药品id删除药品
	 */
	@Override
	public void deleteyaopin(Integer id) {
		// TODO Auto-generated method stub
		yaopinB = new YaopinWithBLOBs();
		yaopinB.setId(id);
		yaopinB.setDm(1);
		try {
			yaopinMapper.updateByPrimaryKeySelective(yaopinB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 更新药品信息
	 */
	@Override
	public void updateyaopin(YaopinWithBLOBs record) {
		// TODO Auto-generated method stub
		try {
			yaopinMapperPro.updateyaopin(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
