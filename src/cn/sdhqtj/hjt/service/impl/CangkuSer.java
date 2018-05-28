package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Cangku;
import cn.sdhqtj.hjt.entity.CangkuVo;
import cn.sdhqtj.hjt.mapper.CangkuMapper;
import cn.sdhqtj.hjt.mapper.CangkuMapperPro;
import cn.sdhqtj.hjt.service.CangkuService;
import cn.sdhqtj.hjt.tool.ExcelTool;

/**
 * 仓库service接口实现类
 */
@Service
public class CangkuSer implements CangkuService {

	@Resource
	private CangkuMapperPro cangkuMapperPro;

	@Resource
	private CangkuMapper cangkuMapper;
	Cangku cangku;
	List<Cangku> cangkulist;
	List<CangkuVo> cangkuVlist;

	/**
	 * 根据分店id获取仓库列表
	 */
	@Override
	public List<Cangku> cangkuquery(int fdid) {
		// TODO Auto-generated method stub
		cangkulist = cangkuMapperPro.cangkuquery(fdid);
		return cangkulist;
	}

	/**
	 * 根据分店id获取仓库列表，从start开始20条记录
	 */
	@Override
	public List<Cangku> getlist(int fdid, int start) {
		// TODO Auto-generated method stub
		cangkulist = cangkuMapperPro.getlist(fdid, start);
		return cangkulist;
	}

	/**
	 * 根据分店id获取仓库列表记录数
	 */
	@Override
	public int getcount(int fdid) {
		// TODO Auto-generated method stub
		return cangkuMapperPro.getcount(fdid);
	}

	/**
	 * 模糊搜索仓库：仓库编号，仓库名称，从start开始20条记录
	 */
	@Override
	public List<Cangku> searchcangku(Cangku record, int start) {
		// TODO Auto-generated method stub
		cangkulist = cangkuMapperPro.searchcangku(record, start);
		return cangkulist;
	}

	/**
	 * 搜索仓库列表记录数
	 */
	@Override
	public int getsearchcount(Cangku record) {
		// TODO Auto-generated method stub
		return cangkuMapperPro.getsearchcount(record);
	}

	/**
	 * 通过仓库id获取仓库信息
	 */
	@Override
	public Cangku getcangku(int id) {
		// TODO Auto-generated method stub
		cangku = cangkuMapper.selectByPrimaryKey(id);
		return cangku;
	}

	/**
	 * 检查重复：仓库编号每个分店唯一
	 */
	@Override
	public List<Cangku> checkrepeat(Cangku record) {
		// TODO Auto-generated method stub
		cangkulist = cangkuMapperPro.checkrepeat(record);
		return cangkulist;
	}

	/**
	 * 添加仓库
	 */
	@Override
	public int addcangku(Cangku record) {
		// TODO Auto-generated method stub
		try {
			return cangkuMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据仓库id删除仓库
	 */
	@Override
	public int deletecangku(int id) {
		// TODO Auto-generated method stub
		cangku = new Cangku();
		cangku.setId(id);
		cangku.setDm(1);
		try {
			return cangkuMapper.updateByPrimaryKeySelective(cangku);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新仓库信息，部分字段
	 */
	@Override
	public int updatecangku(Cangku record) {
		// TODO Auto-generated method stub
		try {
			return cangkuMapperPro.updatecangku(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据分店id生成仓库列表Excel，返回文件路径
	 */
	@Override
	public String writeexcel(int fdid) {
		// TODO Auto-generated method stub
		// Excel模板文件路径
		String inurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\mould\\仓库列表模板.xlsx";
		// 生成的Excel文件路径
		String outurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\maked\\仓库列表.xlsx";

		// 获取仓库列表list，并将其转化为二维数组
		cangkuVlist = cangkuMapperPro.getexcellist(fdid);
		String[][] datas = new String[cangkuVlist.size()][];
		for (int i = 0; i < cangkuVlist.size(); i++) {
			datas[i] = cangkuVlist.get(i).toExcelcol().split(",");
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
