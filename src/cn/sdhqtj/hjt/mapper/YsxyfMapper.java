package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.Ysxyf;

public interface YsxyfMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Ysxyf record);

    int insertSelective(Ysxyf record);

    Ysxyf selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Ysxyf record);

    int updateByPrimaryKey(Ysxyf record);
}