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

	@Override
	public List<YaopinflNode> Yaopinfenleiquery() {
		// TODO Auto-generated method stub
		List<YaopinflNode> listZTree = new ArrayList<YaopinflNode>();
        List<Yaopinfenlei> ypfllist  = ypflMapperPro.Yaopinfenleiquery();
        
        for (int i = 0; i < ypfllist.size(); i++) {  
        	ypfltemp = ypfllist.get(i);//分类信息  
        	ypflnodetemp.setId(ypfltemp.getId());
        	ypflnodetemp.setPid(ypfltemp.getSjflid());
        	ypflnodetemp.setName(ypfltemp.getFlmc());
        	
            listZTree.add(ypflnodetemp);  
        }  
        return listZTree;  
	}

	@Override
	public Yaopinfenlei selectByypflbh(String ypflbh) {
		// TODO Auto-generated method stub
		return ypflMapperPro.selectByypflbh(ypflbh);

	}

	@Override
	public String yaopinfenleiadd(Yaopinfenlei ypfl) {
		// TODO Auto-generated method stub
		ypflMapper.insert(ypfl);
		return ypflMapperPro.lastinsertid();
	}

	@Override
	public void yaopinfenleiupdate(Yaopinfenlei ypfl) {
		// TODO Auto-generated method stub
		ypflMapper.updateByPrimaryKeySelective(ypfl);
	}

	@Override
	public void yaopinfenleidelete(Integer id) {
		// TODO Auto-generated method stub
		ypflMapper.deleteByPrimaryKey(id);
	}

}
