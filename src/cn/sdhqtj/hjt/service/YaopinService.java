package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinVo;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;

/**
 * 药品service接口
 */
@Service
public interface YaopinService {

	/**
	 * 获取药品列表
	 */
	public List<YaopinVo> yaopinquery();

	/**
	 * 获取药品列表，从start开始20条记录
	 */
	List<YaopinVo> getlist(int start);

	/**
	 * 获取药品列表记录数
	 */
	int getcount();

	/**
	 * 模糊搜索药品：药品编号，药品商品名，药品通用名，从start开始20条记录
	 */
	List<YaopinVo> searchyaopin(Yaopin record, int start);

	/**
	 * 搜索药品列表记录数
	 */
	int getsearchcount(Yaopin record);

	/**
	 * 根据药品id获取药品信息
	 */
	public YaopinWithBLOBs getyaopin(int id);

	/**
	 * 检查重复：药品编号
	 */
	public List<Yaopin> checkrepeat(YaopinWithBLOBs record);

	/**
	 * 添加药品
	 */
	public int addyaopin(YaopinWithBLOBs record);

	/**
	 * 根据药品id删除药品
	 */
	public int deleteyaopin(int id);

	/**
	 * 更新药品
	 */
	public int updateyaopin(YaopinWithBLOBs record);

	/**
	 * 生成药品列表Excel，返回文件路径
	 */
	public String writeexcel();

}