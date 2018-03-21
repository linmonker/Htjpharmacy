package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.XsdjMx;

public interface XsdjMxMapper {
	int deleteByPrimaryKey(Long ID);

	int insert(XsdjMx record);

	int insertSelective(XsdjMx record);

	XsdjMx selectByPrimaryKey(Long ID);

	int updateByPrimaryKeySelective(XsdjMx record);

	int updateByPrimaryKey(XsdjMx record);
}