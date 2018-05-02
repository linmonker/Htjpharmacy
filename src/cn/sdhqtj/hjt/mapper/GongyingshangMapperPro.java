package cn.sdhqtj.hjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	 * 根据分店id获取供应商列表
	 */
	List<Gongyingshang> getquerybyfdid(@Param("fdid") int fdid);

	/**
	 * 模糊搜索供应商：供应商编号，供应商名称
	 */
	List<Gongyingshang> searchgongyingshang(Gongyingshang record);

	/**
	 * 检查重复：供应商编号
	 */
	List<Gongyingshang> checkrepeat(Gongyingshang record);

	/**
	 * 更新供应商信息，部分字段
	 */
	int updategongyingshang(GongyingshangWithBLOBs record);

}