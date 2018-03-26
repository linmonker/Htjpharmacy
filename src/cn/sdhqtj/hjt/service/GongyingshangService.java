package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;

/**
 * 供应商service接口
 */
@Service
public interface GongyingshangService {

	/**
	 * 获取供应商列表
	 */
	public List<Gongyingshang> gongyingshangquery();

	/**
	 * 通过供应商id获取供应商信息
	 */
	GongyingshangWithBLOBs selectByPrimaryKey(Integer id);

	/**
	 * 检查重复，供应商编号
	 */
	public Gongyingshang checkrepeat(Gongyingshang record);

	/**
	 * 添加供应商
	 */
	public void gongyingshangadd(GongyingshangWithBLOBs record);

	/**
	 * 更新供应商信息
	 */
	public void gongyingshangupdate(GongyingshangWithBLOBs record);

	/**
	 * 根据供应商id删除供应商
	 */
	public void gongyingshangdelete(Integer id);

}