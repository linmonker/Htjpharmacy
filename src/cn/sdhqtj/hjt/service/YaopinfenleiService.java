package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.entity.YaopinflNode;

@Service
public interface YaopinfenleiService {

	public List<YaopinflNode> Yaopinfenleiquery();

	public Yaopinfenlei selectByypflbh(String ypflbh);

	public String yaopinfenleiadd(Yaopinfenlei ypfl);
	
	public void yaopinfenleiupdate(Yaopinfenlei ypfl);

	public void yaopinfenleidelete(Integer id);
	
}