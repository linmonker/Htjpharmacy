package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Yaopinfenlei;

public interface YaopinfenleiMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Yaopinfenlei record);

	int insertSelective(Yaopinfenlei record);

	Yaopinfenlei selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Yaopinfenlei record);

	int updateByPrimaryKeyWithBLOBs(Yaopinfenlei record);

	int updateByPrimaryKey(Yaopinfenlei record);
}