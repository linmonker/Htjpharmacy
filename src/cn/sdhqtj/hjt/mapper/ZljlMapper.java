package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Zljl;

public interface ZljlMapper {
    int deleteByPrimaryKey(Long ID);

    int insert(Zljl record);

    int insertSelective(Zljl record);

    Zljl selectByPrimaryKey(Long ID);

    int updateByPrimaryKeySelective(Zljl record);

    int updateByPrimaryKeyWithBLOBs(Zljl record);

    int updateByPrimaryKey(Zljl record);
}