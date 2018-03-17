package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;

public interface YaopinMapper {
   
    int deleteByPrimaryKey(Integer id);

    int insert(YaopinWithBLOBs record);

    int insertSelective(YaopinWithBLOBs record);

    YaopinWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YaopinWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(YaopinWithBLOBs record);

    int updateByPrimaryKey(Yaopin record);
}