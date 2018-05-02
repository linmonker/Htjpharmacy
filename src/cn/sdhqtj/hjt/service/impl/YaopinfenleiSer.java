package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.entity.YaopinflNode;
import cn.sdhqtj.hjt.mapper.YaopinfenleiMapper;
import cn.sdhqtj.hjt.mapper.YaopinfenleiMapperPro;
import cn.sdhqtj.hjt.service.YaopinfenleiService;

/**
 * 药品分类service接口实现类
 */
@Service
public class YaopinfenleiSer implements YaopinfenleiService {

	@Resource
	private YaopinfenleiMapperPro ypflMapperPro;

	@Resource
	private YaopinfenleiMapper ypflMapper;
	Yaopinfenlei ypfl;
	List<Yaopinfenlei> ypfllist;

	/**
	 * 获取药品分类列表
	 */
	@Override
	public List<Yaopinfenlei> Yaopinfenleiquery() {
		// TODO Auto-generated method stub
		ypfllist = ypflMapperPro.Yaopinfenleiquery();
		return ypfllist;
	}

	/**
	 * 获取药品分类节点
	 */
	@Override
	public List<YaopinflNode> getypflnodes() {
		// TODO Auto-generated method stub
		List<YaopinflNode> nodeslist = ypflMapperPro.getypflnodes();
		return nodeslist;
	}

	/**
	 * 检查重复：药品分类编号
	 */
	@Override
	public List<Yaopinfenlei> checkrepeat(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		// 如果id为null，则设置id=-1，与数据库所有记录比较
		if (record.getId() == null) {
			record.setId(-1);
		}
		ypfllist = ypflMapperPro.checkrepeat(record);
		return ypfllist;
	}

	/**
	 * 根据药品分类id获取药品分类信息
	 */
	@Override
	public Yaopinfenlei getyaopinfenlei(int id) {
		// TODO Auto-generated method stub
		ypfl = ypflMapper.selectByPrimaryKey(id);
		return ypfl;
	}

	/**
	 * 添加药品分类，添加药品分类，返回id
	 */
	@Override
	public int addyaopinfenlei(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		try {
			ypflMapperPro.addyaopinfenlei(record);
			return record.getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新药品分类
	 */
	@Override
	public int updateyaopinfenlei(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		try {
			return ypflMapperPro.updateyaopinfenlei(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新药品分类名称
	 */
	@Override
	public int updatemingchen(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		ypfl = new Yaopinfenlei();
		ypfl.setId(record.getId());
		ypfl.setFlmc(record.getFlmc());
		try {
			return ypflMapper.updateByPrimaryKeySelective(ypfl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 删除药品分类
	 */
	@Override
	public int deleteyaopinfenlei(int id) {
		// TODO Auto-generated method stub
		ypfl = new Yaopinfenlei();
		ypfl.setId(id);
		ypfl.setZt(1);
		try {
			return ypflMapper.updateByPrimaryKeySelective(ypfl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

}
