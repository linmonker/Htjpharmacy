package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.YsxyfMx;

public interface YsxyfMxMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(YsxyfMx record);

    int insertSelective(YsxyfMx record);

    YsxyfMx selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(YsxyfMx record);

    int updateByPrimaryKey(YsxyfMx record);
}