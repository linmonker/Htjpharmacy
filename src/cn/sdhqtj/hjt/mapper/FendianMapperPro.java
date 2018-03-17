package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Fendian;

public interface FendianMapperPro {

    List<Fendian> fendianquery();
    
    Fendian selectByfdbh(String fdbh);
    
    Fendian selectByfdmc(String fdmc);

}