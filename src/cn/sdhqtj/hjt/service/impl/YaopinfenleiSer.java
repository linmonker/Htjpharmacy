package cn.sdhqtj.hjt.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.sdhqtj.hjt.entity.Yaopinfenlei;
import cn.sdhqtj.hjt.entity.YaopinfenleiVo;
import cn.sdhqtj.hjt.entity.YaopinfenleiNode;
import cn.sdhqtj.hjt.mapper.YaopinfenleiMapper;
import cn.sdhqtj.hjt.mapper.YaopinfenleiMapperPro;
import cn.sdhqtj.hjt.service.YaopinfenleiService;
import cn.sdhqtj.hjt.tool.ExcelTool;

/**
 * 药品分类service接口实现类
 */
@Service
public class YaopinfenleiSer implements YaopinfenleiService {

	@Resource
	private YaopinfenleiMapperPro ypflMapperPro;

	@Resource
	private YaopinfenleiMapper ypflMapper;
	Yaopinfenlei ypfl;
	List<Yaopinfenlei> ypfllist;
	List<YaopinfenleiVo> ypVfllist;

	/**
	 * 获取药品分类列表
	 */
	@Override
	public List<Yaopinfenlei> Yaopinfenleiquery() {
		// TODO Auto-generated method stub
		ypfllist = ypflMapperPro.Yaopinfenleiquery();
		return ypfllist;
	}

	/**
	 * 获取药品分类节点
	 */
	@Override
	public List<YaopinfenleiNode> getypflnodes() {
		// TODO Auto-generated method stub
		List<YaopinfenleiNode> nodeslist = ypflMapperPro.getypflnodes();
		return nodeslist;
	}

	/**
	 * 根据药品分类id获取药品分类信息
	 */
	@Override
	public Yaopinfenlei getyaopinfenlei(int id) {
		// TODO Auto-generated method stub
		ypfl = ypflMapper.selectByPrimaryKey(id);
		return ypfl;
	}

	/**
	 * 检查重复：药品分类编号
	 */
	@Override
	public List<Yaopinfenlei> checkrepeat(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		ypfllist = ypflMapperPro.checkrepeat(record);
		return ypfllist;
	}

	/**
	 * 添加药品分类，添加药品分类，返回id
	 */
	@Override
	public int addyaopinfenlei(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		try {
			ypflMapperPro.addyaopinfenlei(record);
			return record.getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新药品分类
	 */
	@Override
	public int updateyaopinfenlei(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		try {
			return ypflMapperPro.updateyaopinfenlei(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新药品分类名称
	 */
	@Override
	public int updatemingchen(Yaopinfenlei record) {
		// TODO Auto-generated method stub
		ypfl = new Yaopinfenlei();
		ypfl.setId(record.getId());
		ypfl.setFlmc(record.getFlmc());
		try {
			return ypflMapper.updateByPrimaryKeySelective(ypfl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 删除药品分类
	 */
	@Override
	public int deleteyaopinfenlei(int id) {
		// TODO Auto-generated method stub
		ypfl = new Yaopinfenlei();
		ypfl.setId(id);
		ypfl.setZt(1);
		try {
			return ypflMapper.updateByPrimaryKeySelective(ypfl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 生成药品分类列表Excel，返回文件路径
	 */
	@Override
	public String writeexcel() {
		// TODO Auto-generated method stub
		// Excel模板文件路径
		String inurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\mould\\药品分类列表模板.xlsx";
		// 生成的Excel文件路径
		String outurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\maked\\药品分类列表.xlsx";

		// 获取药品分类列表list，并将其转化为二维数组
		ypVfllist = ypflMapperPro.getexcellist();
		String[][] datas = new String[ypVfllist.size()][];
		for (int i = 0; i < ypVfllist.size(); i++) {
			datas[i] = ypVfllist.get(i).toExcelcol().split(",");
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
