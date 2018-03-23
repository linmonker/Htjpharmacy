/**  
* Title: YaopinfenleiSer.java  
* Description:药品分类service实现类  
* @author LIN  
* @date 2018年3月10日  
*/
package cn.sdhqtj.hjt.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.entity.YaopinflNode;
import cn.sdhqtj.hjt.mapper.YaopinfenleiMapper;
import cn.sdhqtj.hjt.mapper.YaopinfenleiMapperPro;
import cn.sdhqtj.hjt.service.YaopinfenleiService;

@Service
public class YaopinfenleiSer implements YaopinfenleiService {

	@Resource
	private YaopinfenleiMapperPro ypflMapperPro;

	@Resource
	private YaopinfenleiMapper ypflMapper;
	Yaopinfenlei ypfl;
	List<Yaopinfenlei> ypfllist;
	YaopinflNode ypflnode;
	List<YaopinflNode> ypflnodelist;

	// 获取药品分类列表
	@Override
	public List<Object> Yaopinfenleiquery() {
		// TODO Auto-generated method stub
		List<Object> listZTree = new ArrayList<Object>();
		List<Yaopinfenlei> ypfllist = ypflMapperPro.Yaopinfenleiquery();
		String str = "0";

		for (int i = 0; i < ypfllist.size(); i++) {
			ypfl = ypfllist.get(i);// 分类信息

			str = "{id:'" + ypfl.getId() + "', pId:'" + ypfl.getSjflid() + "', name:\"" + ypfl.getFlmc()
					+ "\",flbz:\"" + ypfl.getFlbz() +"\" }";// 封装ztree需要格式的字符串

			listZTree.add(str);
		}
		return listZTree;
	}

	// 添加药品分类
	@Override
	public Integer yaopinfenleiadd(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		ypflMapperPro.insertSelective(record);
		return record.getId();
	}

	// 更新药品分类
	@Override
	public void yaopinfenleiupdate(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		ypflMapper.updateByPrimaryKey(record);
	}

	// 删除药品分类
	@Override
	public void yaopinfenleidelete(Integer id) {
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

	/**
	 * 更新药品分类名称
	 * @param record
	 */
	@Override
	public void mingchenupdate(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		ypflMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 根据药品分类id获取药品分类信息
	 * @param id
	 * @return
	 */
	@Override
	public Yaopinfenlei yaopinfenleiget(Integer id) {
		// TODO Auto-generated method stub
		ypfl = ypflMapper.selectByPrimaryKey(id);
		return ypfl;
	}

}
