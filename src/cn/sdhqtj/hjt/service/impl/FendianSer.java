package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Fendian;
import cn.sdhqtj.hjt.mapper.FendianMapper;
import cn.sdhqtj.hjt.mapper.FendianMapperPro;
import cn.sdhqtj.hjt.service.FendianService;
import cn.sdhqtj.hjt.tool.ExcelTool;

/**
 * 分店service接口实现类
 */
@Service
public class FendianSer implements FendianService {

	@Resource
	private FendianMapperPro fendianMapperPro;

	@Resource
	private FendianMapper fendianMapper;
	Fendian fendian;
	List<Fendian> fendianlist;

	/**
	 * 获取分店列表
	 */
	@Override
	public List<Fendian> fendianquery() {
		// TODO Auto-generated method stub
		fendianlist = fendianMapperPro.fendianquery();
		return fendianlist;
	}

	/**
	 * 通过分店id获取分店信息
	 */
	@Override
	public Fendian getfendian(int id) {
		// TODO Auto-generated method stub
		fendian = fendianMapper.selectByPrimaryKey(id);
		return fendian;
	}

	/**
	 * 模糊搜索分店：分店名称
	 */
	@Override
	public List<Fendian> searchfendian(Fendian record) {
		// TODO Auto-generated method stub
		fendianlist = fendianMapperPro.searchfendian(record);
		return fendianlist;
	}

	/**
	 * 检查重复：分店编号，分店名称
	 */
	@Override
	public List<Fendian> checkrepeat(Fendian record) {
		// TODO Auto-generated method stub
		fendianlist = fendianMapperPro.checkrepeat(record);
		return fendianlist;
	}

	/**
	 * 添加分店
	 */
	@Override
	public int addfendian(Fendian record) {
		// TODO Auto-generated method stub
		try {
			return fendianMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据分店id删除分店
	 */
	@Override
	public int deletefendian(int id) {
		// TODO Auto-generated method stub
		fendian = new Fendian();
		fendian.setId(id);
		fendian.setZt(1);
		try {
			return fendianMapper.updateByPrimaryKeySelective(fendian);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新分店信息，部分字段
	 */
	@Override
	public int updatefendian(Fendian record) {
		// TODO Auto-generated method stub
		try {
			return fendianMapperPro.updatefendian(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 生成分店列表Excel，返回文件路径
	 */
	@Override
	public String writeexcel() {
		// TODO Auto-generated method stub

		// Excel模板文件路径
		String inurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\mould\\分店列表模板.xlsx";
		// 生成的Excel文件路径
		String outurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\maked\\分店列表.xlsx";

		// 获取分店列表list，并将其转化为二维数组
		fendianlist = fendianMapperPro.fendianquery();
		String[][] datas = new String[fendianlist.size()][];
		for (int i = 0; i < fendianlist.size(); i++) {
			datas[i] = fendianlist.get(i).toExcelcol().split(",");
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
