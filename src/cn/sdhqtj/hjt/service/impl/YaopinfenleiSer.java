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
	Yaopinfenlei ypfltemp;
	List<Yaopinfenlei> ypfllist;
	YaopinflNode ypflnodetemp;
	List<YaopinflNode> ypflnodelist;

	//获取药品分类列表
	@Override
	public List<Object> Yaopinfenleiquery() {
		// TODO Auto-generated method stub
		List<Object> listZTree = new ArrayList<Object>();
		List<Yaopinfenlei> ypfllist = ypflMapperPro.Yaopinfenleiquery();
		String str = "0";

		for (int i = 0; i < ypfllist.size(); i++) {
			ypfltemp = ypfllist.get(i);// 分类信息

			str = "{id:'" + ypfltemp.getId() + "', pId:'" + ypfltemp.getSjflid() + "', name:\"" + ypfltemp.getFlmc()
					+ "\" }";// 封装ztree需要格式的字符串

			listZTree.add(str);
		}
		return listZTree;
	}

	//添加药品分类
	@Override
	public Integer yaopinfenleiadd(Yaopinfenlei ypfl) {
		// TODO Auto-generated method stub
		ypflMapperPro.insertSelective(ypfl);
		return ypfl.getId();
 	}

	//更新药品分类
	@Override
	public void yaopinfenleiupdate(Yaopinfenlei ypfl) {
		// TODO Auto-generated method stub
		ypflMapper.updateByPrimaryKeySelective(ypfl);
	}

	//删除药品分类
	@Override
	public void yaopinfenleidelete(Integer id) {
		// TODO Auto-generated method stub
		ypflMapper.deleteByPrimaryKey(id);
	}

}
