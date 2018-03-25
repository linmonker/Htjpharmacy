package cn.sdhqtj.hjt.mapper;

import java.util.List;
import cn.sdhqtj.hjt.entity.Huowei;


/**
 * 货位mapper增
 */

public interface HuoweiMapperPro {
 	
    /**
     * 根据仓库id获取货位列表
     */
    List<Huowei> huoweiquery(Integer id);

}