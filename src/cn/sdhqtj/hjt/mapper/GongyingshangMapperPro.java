package cn.sdhqtj.hjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangVo;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;

/**
 * 供应商mapper补充
 */
public interface GongyingshangMapperPro {

	/**
	 * 根据分店id获取供应商列表
	 */
	List<Gongyingshang> gongyingshangquery(int fdid);
	
	/**
	 * 获取全部供应商列表
	 */
	List<GongyingshangVo> gongyingshanAllgquery();

	/**
	 * 获取供应商列表,从start位置开始20条记录
	 */
	List<Gongyingshang> getlist(@Param("fdid") int fdid, @Param("start") int start);

	/**
	 * 获取供应商列表记录数
	 */
	int getcount(@Param("fdid") int fdid);

	/**
	 * 模糊搜索供应商：供应商编号，供应商名称
	 */
	List<Gongyingshang> searchgongyingshang(@Param("gys") Gongyingshang record, @Param("start") int start);

	/**
	 * 获取分店列表搜索记录数
	 */
	int getsearchcount(@Param("gys") Gongyingshang record);
	
	/**
	 * 根据分店id获取供应商Excel列表
	 */
	List<GongyingshangVo> getexcellist(int fdid);

	/**
	 * 检查重复：供应商编号
	 */
	List<Gongyingshang> checkrepeat(Gongyingshang record);

	/**
	 * 更新供应商信息，部分字段
	 */
	int updategongyingshang(GongyingshangWithBLOBs record);

}