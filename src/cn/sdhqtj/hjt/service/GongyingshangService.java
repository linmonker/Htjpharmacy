package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangVo;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;

/**
 * 供应商service接口
 */
@Service
public interface GongyingshangService {

	/**
	 * 根据分店id获取供应商列表
	 */
	public List<Gongyingshang> gongyingshangquery(int fdid);
	
	/**
	 * 获取全部供应商列表
	 */
	List<GongyingshangVo> gongyingshanAllgquery();

	/**
	 * 获取供应商列表,从start位置开始20条记录
	 */
	List<Gongyingshang> getlist(int fdid, int start);

	/**
	 * 获取供应商列表记录数
	 */
	int getcount(int fdid);

	/**
	 * 模糊搜索供应商：供应商编号，供应商名称
	 */
	List<Gongyingshang> searchgongyingshang(Gongyingshang record, int start);

	/**
	 * 获取分店列表搜索记录数
	 */
	int getsearchcount(Gongyingshang record);

	/**
	 * 通过供应商id获取供应商信息
	 */
	GongyingshangWithBLOBs getgongyingshang(int id);

	/**
	 * 检查重复：供应商编号
	 */
	public List<Gongyingshang> checkrepeat(Gongyingshang record);

	/**
	 * 添加供应商
	 */
	public int addgongyingshang(GongyingshangWithBLOBs record);

	/**
	 * 更新供应商信息，部分字段
	 */
	public int updategongyingshang(GongyingshangWithBLOBs record);

	/**
	 * 根据供应商id删除供应商
	 */
	public int deletegongyingshang(int id);

	/**
	 * 根据分店id生成供应商列表Excel，返回文件路径
	 */
	public String writeexcel(int fdid);

}