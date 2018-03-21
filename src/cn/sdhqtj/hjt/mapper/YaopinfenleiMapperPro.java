package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Yaopinfenlei;

public interface YaopinfenleiMapperPro {

	List<Yaopinfenlei> Yaopinfenleiquery();

	Yaopinfenlei selectByypflbh(String ypflbh);

	Integer insertSelective(Yaopinfenlei ypfl);
}