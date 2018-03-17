package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;

@Service
public interface YaopinService {

	public List<Yaopin> yaopinquery();

	public YaopinWithBLOBs yaopinget(Integer id);

	public YaopinWithBLOBs selectByypbh(String ypbh);

	public YaopinWithBLOBs selectByypmc(String ypmc);

	public void yaopinadd(YaopinWithBLOBs yaopin);

	public void yaopindelete(int id);

	public void yaopinUpdate(YaopinWithBLOBs yaopin);

}