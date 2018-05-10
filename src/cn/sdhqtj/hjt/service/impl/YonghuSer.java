package cn.sdhqtj.hjt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Yonghu;
import cn.sdhqtj.hjt.entity.YonghuVo;
import cn.sdhqtj.hjt.mapper.YonghuMapper;
import cn.sdhqtj.hjt.mapper.YonghuMapperPro;
import cn.sdhqtj.hjt.service.YonghuService;
import cn.sdhqtj.hjt.tool.ExcelTool;

/**
 * 用户service接口实现类
 */
@Service
public class YonghuSer implements YonghuService {

	@Resource
	private YonghuMapperPro yonghuMapperPro;

	@Resource
	private YonghuMapper yonghuMapper;
	Yonghu yonghu;
	List<Yonghu> yonghulist;
	List<YonghuVo> yonghuVlist;

	/**
	 * 根据分店id获取用户列表，包括处室名称
	 */
	@Override
	public List<YonghuVo> yonghuquery(int fdid) {
		// TODO Auto-generated method stub
		yonghuVlist = yonghuMapperPro.yonghuquery(fdid);
		return yonghuVlist;
	}

	/**
	 *根据分店id获取用户列表，包括处室名，从start开始20条记录
	 */
	@Override
	public List<YonghuVo> getlist(int fdid, int start) {
		// TODO Auto-generated method stub
		yonghuVlist = yonghuMapperPro.getlist(fdid, start);
		return yonghuVlist;
	}

	/**
	 *根据分店id获取用户列表记录数
	 */
	@Override
	public int getcount(int fdid) {
		// TODO Auto-generated method stub
		return yonghuMapperPro.getcount(fdid);
	}

	/**
	 *模糊搜索用户：用户编号，登录名，姓名，姓名简拼，身份证号，仓库名称，从start开始20条记录
	 */
	@Override
	public List<YonghuVo> searchyonghu(Yonghu record, int start) {
		// TODO Auto-generated method stub
		yonghuVlist = yonghuMapperPro.searchyonghu(record, start);
		return yonghuVlist;
	}

	/**
	 *搜索用户列表记录数
	 */
	@Override
	public int getsearchcount(Yonghu record) {
		// TODO Auto-generated method stub
		return yonghuMapperPro.getsearchcount(record);
	}

	/**
	 * 检查重复：用户编号，用户登录名
	 */
	@Override
	public List<Yonghu> checkrepeat(Yonghu record) {
		// TODO Auto-generated method stub
		yonghulist = yonghuMapperPro.checkrepeat(record);
		return yonghulist;
	}

	/**
	 * 根据用户id获取用户信息
	 */
	@Override
	public Yonghu getuser(int id) {
		// TODO Auto-generated method stub
		yonghu = yonghuMapper.selectByPrimaryKey(id);
		return yonghu;
	}

	/**
	 * 根据用户名获取用户信息,包括分店名称
	 */
	@Override
	public List<YonghuVo> getuserByUseranme(String string) {
		// TODO Auto-generated method stub
		yonghuVlist = yonghuMapperPro.getuserByUseranme(string);
		return yonghuVlist;
	}

	/**
	 * 添加用户
	 */
	@Override
	public int addyonghu(Yonghu record) {
		// TODO Auto-generated method stub
		try {
			return yonghuMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public int updateyonghu(Yonghu record) {
		// TODO Auto-generated method stub
		try {
			return yonghuMapperPro.updateyonghu(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 删除用户信息
	 */
	@Override
	public int deleteyonghu(int id) {
		// TODO Auto-generated method stub
		yonghu = new Yonghu();
		yonghu.setId(id);
		yonghu.setDm(1);
		try {
			return yonghuMapper.updateByPrimaryKeySelective(yonghu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据分店id生成用户列表Excel，返回文件路径
	 */
	@Override
	public String writeexcel(int fdid) {
		// TODO Auto-generated method stub
		// Excel模板文件路径
		String inurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\mould\\用户列表模板.xlsx";
		// 生成的Excel文件路径
		String outurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\maked\\用户列表.xlsx";

		// 获取用户列表list，并将其转化为二维数组
		yonghuVlist = yonghuMapperPro.getexcellist(fdid);
		String[][] datas = new String[yonghuVlist.size()][];
		for (int i = 0; i < yonghuVlist.size(); i++) {
			datas[i] = yonghuVlist.get(i).toExcelcol().split(",");
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
