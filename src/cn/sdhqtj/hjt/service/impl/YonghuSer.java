package cn.sdhqtj.hjt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Yonghu;
import cn.sdhqtj.hjt.entity.YonghuVo;
import cn.sdhqtj.hjt.mapper.YonghuMapper;
import cn.sdhqtj.hjt.mapper.YonghuMapperPro;
import cn.sdhqtj.hjt.service.YonghuService;

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
	List<YonghuVo> yhvolist;

	/**
	 * 根据分店id获取用户列表
	 */
	@Override
	public List<YonghuVo> yonghuquery(Integer id) {
		// TODO Auto-generated method stub
		yhvolist = yonghuMapperPro.yonghuquery(id);
		return yhvolist;
	}

	/**
	 * 根据用户id获取用户信息
	 */
	@Override
	public Yonghu getuser(Integer id) {
		// TODO Auto-generated method stub
		yonghu = yonghuMapper.selectByPrimaryKey(id);
		return yonghu;
	}

	/**
	 * 根据用户名获取用户信息
	 */
	@Override
	public List<Yonghu> getuserByUseranme(String string) {
		// TODO Auto-generated method stub
		yonghulist = yonghuMapperPro.getuserByUseranme(string);
		return yonghulist;
	}

	/**
	 * 搜索用户
	 */
	@Override
	public List<YonghuVo> searchyonghu(Yonghu record) {
		// TODO Auto-generated method stub
		yhvolist = yonghuMapperPro.searchyonghu(record);
		return yhvolist;
	}

	/**
	 * 检查重复，用户编号，用户登录名
	 */
	@Override
	public List<Yonghu> checkrepeat(Yonghu record) {
		// TODO Auto-generated method stub
		yonghulist = yonghuMapperPro.checkrepeat(record);
		return yonghulist;
	}

	/**
	 * 添加用户
	 */
	@Override
	public void addyonghu(Yonghu record) {
		// TODO Auto-generated method stub
		try {
			yonghuMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 更新用户信息
	 */
	@Override
	public void updateyonghu(Yonghu record) {
		// TODO Auto-generated method stub
		try {
			yonghuMapperPro.updateyonghu(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 更新用户信息
	 */
	@Override
	public void deleteyonghu(Integer id) {
		// TODO Auto-generated method stub
		yonghu = new Yonghu();
		yonghu.setId(id);
		yonghu.setDm(1);
		yonghuMapper.updateByPrimaryKeySelective(yonghu);
	}

}
