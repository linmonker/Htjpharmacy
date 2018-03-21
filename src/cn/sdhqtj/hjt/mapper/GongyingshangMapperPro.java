package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;

public interface GongyingshangMapperPro {

	List<Gongyingshang> Gongyingshangquery();

	Gongyingshang selectBygysbh(String gysbh);

	GongyingshangWithBLOBs selectBygysbhWithBLOBs(String gysbh);
}