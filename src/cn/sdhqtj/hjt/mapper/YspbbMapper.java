package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Yspbb;

public interface YspbbMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Yspbb record);

	int insertSelective(Yspbb record);

	Yspbb selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Yspbb record);

	int updateByPrimaryKey(Yspbb record);
}