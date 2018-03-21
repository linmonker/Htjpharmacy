package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Xsdj;

public interface XsdjMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Xsdj record);

	int insertSelective(Xsdj record);

	Xsdj selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Xsdj record);

	int updateByPrimaryKeyWithBLOBs(Xsdj record);

	int updateByPrimaryKey(Xsdj record);
}