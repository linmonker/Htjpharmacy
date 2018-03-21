package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Yisheng;

public interface YishengMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Yisheng record);

	int insertSelective(Yisheng record);

	Yisheng selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Yisheng record);

	int updateByPrimaryKeyWithBLOBs(Yisheng record);

	int updateByPrimaryKey(Yisheng record);
}