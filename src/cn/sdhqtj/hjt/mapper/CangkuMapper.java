package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Cangku;

public interface CangkuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cangku record);

    int insertSelective(Cangku record);

    Cangku selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cangku record);

    int updateByPrimaryKeyWithBLOBs(Cangku record);

    int updateByPrimaryKey(Cangku record);
}