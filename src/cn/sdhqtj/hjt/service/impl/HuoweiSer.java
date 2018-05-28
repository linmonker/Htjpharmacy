package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Huowei;
import cn.sdhqtj.hjt.entity.HuoweiVo;
import cn.sdhqtj.hjt.mapper.HuoweiMapper;
import cn.sdhqtj.hjt.mapper.HuoweiMapperPro;
import cn.sdhqtj.hjt.service.HuoweiService;
import cn.sdhqtj.hjt.tool.ExcelTool;

/**
 * 货位service接口实现类
 */
@Service
public class HuoweiSer implements HuoweiService {

	@Resource
	private HuoweiMapperPro huoweiMapperPro;

	@Resource
	private HuoweiMapper huoweiMapper;
	Huowei huowei;
	List<Huowei> huoweilist;
	List<HuoweiVo> huoweiVlist;

	/**
	 * 根据仓库id获取货位列表
	 */
	@Override
	public List<Huowei> huoweiquery(int ckid) {
		// TODO Auto-generated method stub
		huoweilist = huoweiMapperPro.huoweiquery(ckid);
		return huoweilist;
	}

	/**
	 * 根据仓库id获取货位列表，从start开始20条记录
	 */
	@Override
	public List<Huowei> getlist(int ckid, int start) {
		// TODO Auto-generated method stub
		huoweilist = huoweiMapperPro.getlist(ckid, start);
		return huoweilist;
	}

	/**
	 * 根据仓库id获取货位列表记录数
	 */
	@Override
	public int getcount(int ckid) {
		// TODO Auto-generated method stub
		return huoweiMapperPro.getcount(ckid);
	}

	/**
	 * 模糊搜索货位：货位名称，从start开始20条记录
	 */
	@Override
	public List<Huowei> searchhuowei(Huowei record, int start) {
		// TODO Auto-generated method stub
		huoweilist = huoweiMapperPro.searchhuowei(record, start);
		return huoweilist;
	}

	/**
	 * 搜索仓库列表记录数
	 */
	@Override
	public int getsearchcount(Huowei record) {
		// TODO Auto-generated method stub
		return huoweiMapperPro.getsearchcount(record);
	}

	/**
	 * 通过货位id获取货位信息
	 */
	@Override
	public Huowei gethuowei(int id) {
		// TODO Auto-generated method stub
		huowei = huoweiMapper.selectByPrimaryKey(id);
		return huowei;
	}

	/**
	 * 检查重复：货物编号同一仓库唯一
	 */
	@Override
	public List<Huowei> checkrepeat(Huowei record) {
		// TODO Auto-generated method stub
		huoweilist = huoweiMapperPro.checkrepeat(record);
		return huoweilist;
	}

	/**
	 * 添加货位
	 */
	@Override
	public int addhuowei(Huowei record) {
		// TODO Auto-generated method stub
		try {
			return huoweiMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据货位id删除货位
	 */
	@Override
	public int deletehuowei(int id) {
		// TODO Auto-generated method stub
		huowei = new Huowei();
		huowei.setId(id);
		huowei.setDm(1);
		try {
			return huoweiMapper.updateByPrimaryKeySelective(huowei);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新货位信息
	 */
	@Override
	public int updatehuowei(Huowei record) {
		// TODO Auto-generated method stub
		try {
			return huoweiMapperPro.updatehuowei(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据仓库id生成货位列表Excel，返回文件路径
	 */
	@Override
	public String writeexcel(int ckid) {
		// TODO Auto-generated method stub
		// Excel模板文件路径
		String inurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\mould\\货位列表模板.xlsx";
		// 生成的Excel文件路径
		String outurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\maked\\货位列表.xlsx";

		// 获取货位列表list，并将其转化为二维数组
		huoweiVlist = huoweiMapperPro.getexcellist(ckid);
		String[][] datas = new String[huoweiVlist.size()][];
		for (int i = 0; i < huoweiVlist.size(); i++) {
			datas[i] = huoweiVlist.get(i).toExcelcol().split(",");
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
