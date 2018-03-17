package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Huanzhe;

public interface HuanzheMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Huanzhe record);

    int insertSelective(Huanzhe record);

    Huanzhe selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Huanzhe record);

    int updateByPrimaryKeyWithBLOBs(Huanzhe record);

    int updateByPrimaryKey(Huanzhe record);
}