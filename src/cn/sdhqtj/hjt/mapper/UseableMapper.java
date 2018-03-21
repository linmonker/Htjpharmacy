package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Useable;

public interface UseableMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Useable record);

	int insertSelective(Useable record);

	Useable selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Useable record);

	int updateByPrimaryKey(Useable record);
}