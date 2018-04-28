package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;

/**
 * 供应商mapper补充
 */
public interface GongyingshangMapperPro {

	/**
	 * 获取供应商列表
	 */
	List<Gongyingshang> gongyingshangquery();
	
	/**
	 * 搜索供应商
	 */
	List<Gongyingshang> searchgongyingshang(Gongyingshang record);

	/**
	 * 检查重复，供应商编号
	 */
	List<Gongyingshang> checkrepeat(Gongyingshang record);
	
	/**
	 *更新供应商信息，选择字段
	 */
	GongyingshangWithBLOBs updategongyingshang(GongyingshangWithBLOBs record);

}