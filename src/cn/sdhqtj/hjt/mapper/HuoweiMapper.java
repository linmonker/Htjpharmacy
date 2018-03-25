package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Huowei;

public interface HuoweiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huowei record);

    int insertSelective(Huowei record);

    Huowei selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huowei record);

    int updateByPrimaryKeyWithBLOBs(Huowei record);

    int updateByPrimaryKey(Huowei record);
}