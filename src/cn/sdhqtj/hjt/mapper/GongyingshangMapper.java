package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;

public interface GongyingshangMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(GongyingshangWithBLOBs record);

	int insertSelective(GongyingshangWithBLOBs record);

	GongyingshangWithBLOBs selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(GongyingshangWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(GongyingshangWithBLOBs record);

	int updateByPrimaryKey(Gongyingshang record);
}