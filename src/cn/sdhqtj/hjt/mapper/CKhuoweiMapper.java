package cn.sdhqtj.hjt.mapper;

import cn.sdhqtj.hjt.entity.CKhuowei;

public interface CKhuoweiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CKhuowei record);

    int insertSelective(CKhuowei record);

    CKhuowei selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CKhuowei record);

    int updateByPrimaryKeyWithBLOBs(CKhuowei record);

    int updateByPrimaryKey(CKhuowei record);
}