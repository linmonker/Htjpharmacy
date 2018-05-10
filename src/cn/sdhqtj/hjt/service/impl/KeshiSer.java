package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Keshi;
import cn.sdhqtj.hjt.entity.KeshiVo;
import cn.sdhqtj.hjt.mapper.KeshiMapper;
import cn.sdhqtj.hjt.mapper.KeshiMapperPro;
import cn.sdhqtj.hjt.service.KeshiService;
import cn.sdhqtj.hjt.tool.ExcelTool;

/**
 * 科室service接口实现类
 */
@Service
public class KeshiSer implements KeshiService {

	@Resource
	private KeshiMapperPro keshiMapperPro;

	@Resource
	private KeshiMapper keshiMapper;
	Keshi keshi;
	List<Keshi> keshilist;
	List<KeshiVo> keshiVlist;

	/**
	 * 根据分店id获取科室列表
	 */
	@Override
	public List<Keshi> keshiquery(int id) {
		// TODO Auto-generated method stub
		keshilist = keshiMapperPro.keshiquery(id);
		return keshilist;
	}

	/**
	 * 根据分店id获取科室列表，从start开始20条记录
	 */
	@Override
	public List<Keshi> getlist(int fdid, int start) {
		// TODO Auto-generated method stub
		keshilist = keshiMapperPro.getlist(fdid, fdid);
		return keshilist;
	}

	/**
	 * 根据分店id获取科室列表记录数
	 */
	@Override
	public int getcount(int fdid) {
		// TODO Auto-generated method stub
		return keshiMapperPro.getcount(fdid);
	}

	/**
	 * 模糊搜索科室：科室名称，从start开始20条记录
	 */
	@Override
	public List<Keshi> searchkeshi(Keshi record, int start) {
		// TODO Auto-generated method stub
		keshilist = keshiMapperPro.searchkeshi(record, start);
		return keshilist;
	}

	/**
	 * 搜索科室列表记录数
	 */
	@Override
	public int getsearchcount(Keshi record) {
		// TODO Auto-generated method stub
		return keshiMapperPro.getsearchcount(record);
	}

	/**
	 * 根据科室id获取科室信息
	 */
	@Override
	public Keshi getkeshi(int id) {
		// TODO Auto-generated method stub
		keshi = keshiMapper.selectByPrimaryKey(id);
		return keshi;
	}

	/**
	 * 检查重复：科室编号同一分店唯一
	 */
	@Override
	public List<Keshi> checkrepeat(Keshi record) {
		// TODO Auto-generated method stub
		keshilist = keshiMapperPro.checkrepeat(record);
		return keshilist;
	}

	/**
	 * 添加科室
	 */
	@Override
	public int addkeshi(Keshi record) {
		// TODO Auto-generated method stub
		try {
			return keshiMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据科室id删除科室
	 */
	@Override
	public int deletekeshi(int id) {
		// TODO Auto-generated method stub
		keshi = new Keshi();
		keshi.setId(id);
		keshi.setDm(1);
		try {
			return keshiMapper.updateByPrimaryKeySelective(keshi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新科室信息
	 */
	@Override
	public int updatekeshi(Keshi record) {
		// TODO Auto-generated method stub
		try {
			return keshiMapperPro.updatekeshi(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据分店id生成科室列表Excel，返回文件路径
	 */
	@Override
	public String writeexcel(int fdid) {
		// TODO Auto-generated method stub
		// Excel模板文件路径
		String inurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\mould\\科室列表模板.xlsx";
		// 生成的Excel文件路径
		String outurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\maked\\科室列表.xlsx";

		// 获取科室列表list，并将其转化为二维数组
		keshiVlist = keshiMapperPro.getexcellist(fdid);
		String[][] datas = new String[keshiVlist.size()][];
		for (int i = 0; i < keshiVlist.size(); i++) {
			datas[i] = keshiVlist.get(i).toExcelcol().split(",");
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
