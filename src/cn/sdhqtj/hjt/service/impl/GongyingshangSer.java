package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangVo;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;
import cn.sdhqtj.hjt.mapper.GongyingshangMapper;
import cn.sdhqtj.hjt.mapper.GongyingshangMapperPro;
import cn.sdhqtj.hjt.service.GongyingshangService;
import cn.sdhqtj.hjt.tool.ExcelTool;

/**
 * 供应商service接口实现类
 */
@Service
public class GongyingshangSer implements GongyingshangService {

	@Resource
	private GongyingshangMapperPro gysMapperPro;

	@Resource
	private GongyingshangMapper gysMapper;
	Gongyingshang gys;
	GongyingshangWithBLOBs gysB;
	List<Gongyingshang> gyslist;
	List<GongyingshangVo> gysVlist;

	/**
	 * 根据分店id获取供应商列表
	 */
	@Override
	public List<Gongyingshang> gongyingshangquery(int fdid) {
		// TODO Auto-generated method stub
		gyslist = gysMapperPro.gongyingshangquery(fdid);
		return gyslist;
	}

	/**
	 * 获取全部供应商列表
	 */
	@Override
	public List<GongyingshangVo> gongyingshanAllgquery() {
		// TODO Auto-generated method stub
		gysVlist = gysMapperPro.gongyingshanAllgquery();
		return gysVlist;
	}

	/**
	 * 获取供应商列表,从start位置开始20条记录
	 */
	@Override
	public List<Gongyingshang> getlist(int fdid, int start) {
		// TODO Auto-generated method stub
		gyslist = gysMapperPro.getlist(fdid, start);
		return gyslist;
	}

	/**
	 * 获取供应商列表记录数
	 */
	@Override
	public int getcount(int fdid) {
		// TODO Auto-generated method stub
		return gysMapperPro.getcount(fdid);
	}

	/**
	 * 模糊搜索供应商：供应商编号，供应商名称
	 */
	@Override
	public List<Gongyingshang> searchgongyingshang(Gongyingshang record, int start) {
		// TODO Auto-generated method stub
		gyslist = gysMapperPro.searchgongyingshang(record, start);
		return gyslist;
	}

	/**
	 * 获取分店列表搜索记录数
	 */
	@Override
	public int getsearchcount(Gongyingshang record) {
		// TODO Auto-generated method stub
		return gysMapperPro.getsearchcount(record);
	}

	/**
	 * 通过供应商id获取供应商信息
	 */
	@Override
	public GongyingshangWithBLOBs getgongyingshang(int id) {
		// TODO Auto-generated method stub
		gysB = gysMapper.selectByPrimaryKey(id);
		return gysB;
	}

	/**
	 * 检查重复：供应商编号
	 */
	@Override
	public List<Gongyingshang> checkrepeat(Gongyingshang record) {
		// TODO Auto-generated method stub
		gyslist = gysMapperPro.checkrepeat(record);
		return gyslist;
	}

	/**
	 * 添加供应商
	 */
	@Override
	public int addgongyingshang(GongyingshangWithBLOBs record) {
		// TODO Auto-generated method stub
		try {
			return gysMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新供应商
	 */
	@Override
	public int updategongyingshang(GongyingshangWithBLOBs record) {
		// TODO Auto-generated method stub
		try {
			return gysMapperPro.updategongyingshang(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据供应商id删除供应商
	 */
	@Override
	public int deletegongyingshang(int id) {
		// TODO Auto-generated method stub
		gysB = new GongyingshangWithBLOBs();
		gysB.setId(id);
		gysB.setDm(1);
		try {
			return gysMapper.updateByPrimaryKeySelective(gysB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据分店id生成供应商列表Excel，返回文件路径
	 */
	@Override
	public String writeexcel(int fdid) {
		// TODO Auto-generated method stub
		// Excel模板文件路径
		String inurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\mould\\供应商列表模板.xlsx";
		// 生成的Excel文件路径
		String outurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\maked\\供应商列表.xlsx";

		// 获取供应商列表list，并将其转化为二维数组
		gysVlist = gysMapperPro.getexcellist(fdid);
		String[][] datas = new String[gysVlist.size()][];
		for (int i = 0; i < gysVlist.size(); i++) {
			datas[i] = gysVlist.get(i).toExcelcol().split(",");
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
