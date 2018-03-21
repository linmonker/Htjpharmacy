package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.ZljlMx;

public interface ZljlMxMapper {
	int deleteByPrimaryKey(Long ID);

	int insert(ZljlMx record);

	int insertSelective(ZljlMx record);

	ZljlMx selectByPrimaryKey(Long ID);

	int updateByPrimaryKeySelective(ZljlMx record);

	int updateByPrimaryKey(ZljlMx record);
}