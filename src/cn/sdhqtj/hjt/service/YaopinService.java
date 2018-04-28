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
	 * 根据药品id获取药品信息
	 */
	public YaopinWithBLOBs getyaopin(Integer id);
	
	/**
	 * 搜索药品
	 */
	List<YaopinVo> searchyaopin(Yaopin record);

	/**
	 * 检查重复，药品编号
	 */
	public List<Yaopin> checkrepeat(String record);

	/**
	 * 添加药品
	 */
	public void addyaopin(YaopinWithBLOBs record);

	/**
	 * 根据药品id删除药品
	 */
	public void deleteyaopin(Integer id);

	/**
	 * 更新药品
	 */
	public void updateyaopin(YaopinWithBLOBs record);

}