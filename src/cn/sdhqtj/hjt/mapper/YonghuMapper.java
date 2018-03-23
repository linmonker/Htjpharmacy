package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Yonghu;

public interface YonghuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yonghu record);

    int insertSelective(Yonghu record);

    Yonghu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yonghu record);

    int updateByPrimaryKeyWithBLOBs(Yonghu record);

    int updateByPrimaryKey(Yonghu record);
}