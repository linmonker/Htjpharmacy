package cn.sdhqtj.hjt.service;

import java.util.List;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Huowei;

@Service
public interface HuoweiService {

	// 根据仓库id获取货位列表
	public List<Huowei> huoweiquery(Integer id);

	// 通过货位id获取货位信息
	public Huowei huoweiget(Integer id);

	// 通过货位编号获取货位信息
	public Huowei selectBybh(String string);

	// 通过分货位称获取货位信息
	public Huowei selectBymc(String string);

	// 添加货位
	public void huoweiadd(Huowei record);

	// 根据货位id删除货位
	public void huoweidelete(Integer id);

	// 更新货位信息
	public void huoweiupdate(Huowei record);

}