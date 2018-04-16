package cn.sdhqtj.hjt.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Yaopinfenlei;
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
	 * 获取药品分类json列表
	 */
	public List<Object> gettreelist() {
		// TODO Auto-generated method stub
		List<Object> listZTree = new ArrayList<Object>();
		ypfllist = ypflMapperPro.Yaopinfenleiquery();
		String str = "0";

		for (int i = 0; i < ypfllist.size(); i++) {
			ypfl = ypfllist.get(i);// 分类信息
            // 封装ztree需要格式的字符串
			str = "{id:'" + ypfl.getId() + "', pId:'" + ypfl.getSjflid() + "', name:\"" + ypfl.getFlmc() + "\",flbz:\""
					+ ypfl.getFlbz() + "\" }";

			listZTree.add(str);
		}
		return listZTree;
	}

	/**
	 * 检查重复，药品分类编号
	 */
	@Override
	public Yaopinfenlei checkrepeat(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		if(record.getFlbh() != null) {
			ypfl = ypflMapperPro.checkrepeat(record);
			return ypfl;
		}else {
			return null;
		}	
	}

	/**
	 * 根据药品分类id获取药品分类信息
	 */
	@Override
	public Yaopinfenlei getyaopinfenlei(Integer id) {
		// TODO Auto-generated method stub
		ypfl = ypflMapper.selectByPrimaryKey(id);
		return ypfl;
	}

	/**
	 * 添加药品分类
	 */
	@Override
	public Integer addyaopinfenlei(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		ypflMapperPro.insertSelective(record);
		return record.getId();
	}

	/**
	 * 更新药品分类
	 */
	@Override
	public void updateyaopinfenlei(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		try {
			ypflMapperPro.updateyaopinfenlei(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 更新药品分类名称
	 */
	@Override
	public void updatemingchen(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		ypfl = new Yaopinfenlei();
		ypfl.setId(record.getId());
		ypfl.setFlmc(record.getFlmc());
		try {
			ypflMapper.updateByPrimaryKeySelective(ypfl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除药品分类
	 */
	@Override
	public void deleteyaopinfenlei(Integer id) {
		// TODO Auto-generated method stub
		ypfl = new Yaopinfenlei();
		ypfl.setId(id);
		ypfl.setZt(1);
		try {
			ypflMapper.updateByPrimaryKeySelective(ypfl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
