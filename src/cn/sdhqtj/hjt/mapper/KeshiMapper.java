package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Keshi;

public interface KeshiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Keshi record);

    int insertSelective(Keshi record);

    Keshi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Keshi record);

    int updateByPrimaryKeyWithBLOBs(Keshi record);

    int updateByPrimaryKey(Keshi record);
}