package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Fendian;

public interface FendianMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fendian record);

    int insertSelective(Fendian record);

    Fendian selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fendian record);

    int updateByPrimaryKeyWithBLOBs(Fendian record);

    int updateByPrimaryKey(Fendian record);
}