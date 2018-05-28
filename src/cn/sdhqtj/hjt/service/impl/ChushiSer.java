package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Zuzhijigou;
import cn.sdhqtj.hjt.entity.ZuzhijigouVo;
import cn.sdhqtj.hjt.mapper.ZuzhijigouMapper;
import cn.sdhqtj.hjt.mapper.ZuzhijigouMapperPro;
import cn.sdhqtj.hjt.service.ChushiService;
import cn.sdhqtj.hjt.tool.ExcelTool;

/**
 * 处室service接口实现类
 */
@Service
public class ChushiSer implements ChushiService {

	@Resource
	private ZuzhijigouMapperPro zuzhijigouMapperPro;

	@Resource
	private ZuzhijigouMapper zuzhijigouMapper;
	Zuzhijigou chushi;
	List<Zuzhijigou> chushilist;
	List<ZuzhijigouVo> chushiVlist;

	/**
	 * 根据分店id获取处室列表
	 */
	@Override
	public List<Zuzhijigou> chushiquery(int fdid) {
		// TODO Auto-generated method stub
		chushilist = zuzhijigouMapperPro.chushiquery(fdid);
		return chushilist;
	}

	/**
	 * 根据分店id获取处室列表，从start开始20条记录
	 */
	@Override
	public List<Zuzhijigou> getlist(int fdid, int start) {
		// TODO Auto-generated method stub
		chushilist = zuzhijigouMapperPro.getlist(fdid, start);
		return chushilist;
	}

	/**
	 * 根据分店id获取处室列表记录数
	 */
	@Override
	public int getcount(int fdid) {
		// TODO Auto-generated method stub
		return zuzhijigouMapperPro.getcount(fdid);
	}

	/**
	 * 模糊搜索处室：处室名称，从start开始20条记录
	 */
	@Override
	public List<Zuzhijigou> searchchushi(Zuzhijigou record, int start) {
		// TODO Auto-generated method stub
		chushilist = zuzhijigouMapperPro.searchchushi(record, start);
		return chushilist;
	}

	/**
	 * 搜索处室列表记录数
	 */
	@Override
	public int getsearchcount(Zuzhijigou record) {
		// TODO Auto-generated method stub
		return zuzhijigouMapperPro.getsearchcount(record);
	}

	/**
	 * 根据处室id获取处室信息
	 */
	@Override
	public Zuzhijigou getchushi(int id) {
		// TODO Auto-generated method stub
		chushi = zuzhijigouMapper.selectByPrimaryKey(id);
		return chushi;
	}

	/**
	 * 检查重复：处室编号同一分店唯一
	 */
	@Override
	public List<Zuzhijigou> checkrepeat(Zuzhijigou record) {
		// TODO Auto-generated method stub
		chushilist = zuzhijigouMapperPro.checkrepeat(record);
		return chushilist;
	}

	/**
	 * 添加处室
	 */
	@Override
	public int addchushi(Zuzhijigou record) {
		// TODO Auto-generated method stub
		try {
			return zuzhijigouMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据处室id删除处室
	 */
	@Override
	public int deletechushi(int id) {
		// TODO Auto-generated method stub
		chushi = new Zuzhijigou();
		chushi.setId(id);
		chushi.setDm(1);
		try {
			return zuzhijigouMapper.updateByPrimaryKeySelective(chushi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新处室信息
	 */
	@Override
	public int updatechushi(Zuzhijigou record) {
		// TODO Auto-generated method stub
		try {
			return zuzhijigouMapperPro.updatechushi(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据分店id生成处室列表Excel，返回文件路径
	 */
	@Override
	public String writeexcel(int fdid) {
		// TODO Auto-generated method stub
		// Excel模板文件路径
		String inurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\mould\\处室列表模板.xlsx";
		// 生成的Excel文件路径
		String outurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\maked\\处室列表.xlsx";

		// 获取处室列表list，并将其转化为二维数组
		chushiVlist = zuzhijigouMapperPro.getexcellist(fdid);
		String[][] datas = new String[chushiVlist.size()][];
		for (int i = 0; i < chushiVlist.size(); i++) {
			datas[i] = chushiVlist.get(i).toExcelcol().split(",");
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
