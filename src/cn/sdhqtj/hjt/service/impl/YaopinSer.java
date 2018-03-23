/**  
* Title: YaopinfenleiSer.java  
* Description:药品service实现类 
* @author LIN  
* @date 2018年3月10日  
*/
package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;
import cn.sdhqtj.hjt.mapper.YaopinMapper;
import cn.sdhqtj.hjt.mapper.YaopinMapperPro;
import cn.sdhqtj.hjt.service.YaopinService;

@Service
public class YaopinSer implements YaopinService {

	@Resource
	private YaopinMapperPro yaopinMapperPro;

	@Resource
	private YaopinMapper yaopinMapper;
	Yaopin yaopintemp;
	YaopinWithBLOBs yaopinBtemp;

	// 获取药品列表
	@Override
	public List<Yaopin> yaopinquery() {
		// TODO Auto-generated method stub
		List<Yaopin> list = yaopinMapperPro.yaopinquery();
		return list;
	}

	// 根据药品id获取药品信息
	@Override
	public YaopinWithBLOBs yaopinget(Integer id) {
		// TODO Auto-generated method stub
		yaopinBtemp = yaopinMapper.selectByPrimaryKey(id);
		return yaopinBtemp;
	}

	// 根据药品编号获取药品信息
	@Override
	public YaopinWithBLOBs selectByypbh(String ypbh) {
		// TODO Auto-generated method stub
		yaopinBtemp = yaopinMapperPro.selectByypbh(ypbh);
		return yaopinBtemp;
	}

	// 添加药品
	@Override
	public void yaopinadd(YaopinWithBLOBs yaopin) {
		// TODO Auto-generated method stub
		yaopinMapper.insert(yaopin);

	}

	// 根据药品id删除药品
	@Override
	public void yaopindelete(Integer id) {
		// TODO Auto-generated method stub
		yaopinBtemp = new YaopinWithBLOBs();
		yaopinBtemp.setId(id);
		yaopinBtemp.setDm(1);
		try {	
			yaopinMapper.updateByPrimaryKeySelective(yaopinBtemp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 更新药品
	@Override
	public void yaopinupdate(YaopinWithBLOBs yaopin) {
		// TODO Auto-generated method stub
		try {
			yaopinMapper.updateByPrimaryKeySelective(yaopin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
