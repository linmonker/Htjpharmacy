package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Yaopin;
import cn.sdhqtj.hjt.entity.YaopinVo;
import cn.sdhqtj.hjt.entity.YaopinWithBLOBs;
import cn.sdhqtj.hjt.mapper.YaopinMapper;
import cn.sdhqtj.hjt.mapper.YaopinMapperPro;
import cn.sdhqtj.hjt.service.YaopinService;
import cn.sdhqtj.hjt.tool.ExcelTool;

/**
 * 药品service接口实现类
 */
@Service
public class YaopinSer implements YaopinService {

	@Resource
	private YaopinMapperPro yaopinMapperPro;

	@Resource
	private YaopinMapper yaopinMapper;
	Yaopin yaopin;
	List<Yaopin> yaopinlist;
	YaopinWithBLOBs yaopinB;
	List<YaopinVo> yaopinVlist;

	/**
	 * 获取药品列表
	 */
	@Override
	public List<YaopinVo> yaopinquery() {
		// TODO Auto-generated method stub
		yaopinVlist = yaopinMapperPro.yaopinquery();
		return yaopinVlist;
	}

	/**
	 * 根据药品id获取药品信息
	 */
	@Override
	public YaopinWithBLOBs getyaopin(int id) {
		// TODO Auto-generated method stub
		yaopinB = yaopinMapper.selectByPrimaryKey(id);
		return yaopinB;
	}

	/**
	 * 模糊搜索药品：药品编号，药品商品名，药品通用名
	 */
	@Override
	public List<YaopinVo> searchyaopin(Yaopin record) {
		// TODO Auto-generated method stub
		yaopinVlist = yaopinMapperPro.searchyaopin(record);
		return yaopinVlist;
	}

	/**
	 * 检查重复：药品编号
	 */
	@Override
	public List<Yaopin> checkrepeat(YaopinWithBLOBs record) {
		// TODO Auto-generated method stub
		yaopinlist = yaopinMapperPro.checkrepeat(record);
		return yaopinlist;
	}

	/**
	 * 添加药品
	 */
	@Override
	public int addyaopin(YaopinWithBLOBs record) {
		// TODO Auto-generated method stub
		try {
			return yaopinMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据药品id删除药品
	 */
	@Override
	public int deleteyaopin(int id) {
		// TODO Auto-generated method stub
		yaopinB = new YaopinWithBLOBs();
		yaopinB.setId(id);
		yaopinB.setDm(1);
		try {
			return yaopinMapper.updateByPrimaryKeySelective(yaopinB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新药品信息
	 */
	@Override
	public int updateyaopin(YaopinWithBLOBs record) {
		// TODO Auto-generated method stub
		try {
			return yaopinMapperPro.updateyaopin(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 生成药品列表Excel，返回文件路径
	 */
	@Override
	public String writeexcel() {
		// TODO Auto-generated method stub
		// Excel模板文件路径
		String inurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\mould\\药品列表模板.xlsx";
		// 生成的Excel文件路径
		String outurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\maked\\药品列表.xlsx";

		// 获取药品列表list，并将其转化为二维数组
		yaopinVlist = yaopinMapperPro.getexcellist();
		String[][] datas = new String[yaopinVlist.size()][];
		for (int i = 0; i < yaopinVlist.size(); i++) {
			datas[i] = yaopinVlist.get(i).toExcelcol().split(",");
		}

		// 根据Excel模板文件生成Excel文件
		ExcelTool et = new ExcelTool();
		try {
			et.WriteExcel(inurl, outurl, datas);
			return outurl;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return inurl;
		}
	}

}
