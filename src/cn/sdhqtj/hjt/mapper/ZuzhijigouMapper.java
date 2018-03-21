package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Zuzhijigou;

public interface ZuzhijigouMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Zuzhijigou record);

	int insertSelective(Zuzhijigou record);

	Zuzhijigou selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Zuzhijigou record);

	int updateByPrimaryKeyWithBLOBs(Zuzhijigou record);

	int updateByPrimaryKey(Zuzhijigou record);
}