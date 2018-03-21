package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;

public interface YaopinMapperPro {

	List<Yaopin> yaopinquery();

	YaopinWithBLOBs selectByypbh(String ypbh);

	YaopinWithBLOBs selectByypmc(String ypmc);
}