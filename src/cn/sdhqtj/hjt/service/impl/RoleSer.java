package cn.sdhqtj.hjt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.AccessNode;
import cn.sdhqtj.hjt.entity.MenuNode;
import cn.sdhqtj.hjt.entity.Role;
import cn.sdhqtj.hjt.entity.RoleVo;
import cn.sdhqtj.hjt.mapper.RoleMapper;
import cn.sdhqtj.hjt.mapper.RoleMapperPro;
import cn.sdhqtj.hjt.service.RoleService;
import cn.sdhqtj.hjt.tool.ExcelTool;

/**
 * 角色service接口实现类
 */
@Service
public class RoleSer implements RoleService {

	@Resource
	private RoleMapperPro roleMapperPro;

	@Resource
	private RoleMapper roleMapper;
	Role role;
	List<Role> rolelist;
	List<RoleVo> roleVlist;

	/**
	 * 获取角色列表
	 */
	@Override
	public List<Role> rolequery() {
		// TODO Auto-generated method stub
		rolelist = roleMapperPro.rolequery();
		return rolelist;
	}

	/**
	 * 根据角色id获取角色
	 */
	@Override
	public Role getrole(int id) {
		// TODO Auto-generated method stub
		role = roleMapper.selectByPrimaryKey(id);
		return role;
	}

	/**
	 * 根据角色id获取角色名称
	 */
	@Override
	public List<String> rolenamelist(int id) {
		// TODO Auto-generated method stub
		List<String> sl = roleMapperPro.rolenamelist(id);
		return sl;
	}

	/**
	 * 模糊搜索角色：角色名称
	 */
	@Override
	public List<Role> searchrole(Role record) {
		// TODO Auto-generated method stub
		rolelist = roleMapperPro.searchrole(record);
		return rolelist;
	}

	/**
	 * 检查重复：角色名称
	 */
	@Override
	public List<Role> checkrepeat(Role record) {
		// TODO Auto-generated method stub
		rolelist = roleMapperPro.checkrepeat(record);
		return rolelist;
	}

	/**
	 * 添加角色,返回id
	 */
	@Override
	public int addrole(Role record) {
		// TODO Auto-generated method stub
		try {
			return roleMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 更新角色信息
	 */
	@Override
	public int updaterole(Role record) {
		// TODO Auto-generated method stub
		try {
			return roleMapperPro.updaterole(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据角色id删除角色
	 */
	@Override
	public int deleterole(Integer id) {
		// TODO Auto-generated method stub
		role = new Role();
		role.setRole_id(id);
		role.setDm(1);
		try {
			return roleMapper.updateByPrimaryKeySelective(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 生成角色列表Excel，返回文件路径
	 */
	@Override
	public String writeexcel() {
		// TODO Auto-generated method stub
		// Excel模板文件路径
		String inurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\mould\\角色列表模板.xlsx";
		// 生成的Excel文件路径
		String outurl = "D:\\Users\\lenovo\\eclipse-workspace\\Htjpharmacy\\WebContent\\static\\excel\\maked\\角色列表.xlsx";

		// 获取角色列表list，并将其转化为二维数组
		roleVlist = roleMapperPro.getexcellist();
		String[][] datas = new String[roleVlist.size()][];
		for (int i = 0; i < roleVlist.size(); i++) {
			datas[i] = roleVlist.get(i).toExcelcol().split(",");
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

	/**
	 * 根据角色id获取相关权限url
	 */
	@Override
	public List<String> urllist(int id) {
		// TODO Auto-generated method stub
		List<String> sl = roleMapperPro.urllist(id);
		return sl;
	}

	/**
	 * 获取权限菜单
	 */
	@Override
	public List<MenuNode> getmenunodes() {
		// TODO Auto-generated method stub
		List<MenuNode> mlist = roleMapperPro.getmenunodes();
		return mlist;
	}

	/**
	 * 根据角色id获取角色权限
	 */
	@Override
	public List<AccessNode> getquanxian(int id) {
		// TODO Auto-generated method stub
		List<AccessNode> alist = roleMapperPro.getquanxian(id);
		return alist;
	}

	/**
	 * 批量添加角色权限
	 */
	@Override
	public int addquanxian(List<AccessNode> list) {
		// TODO Auto-generated method stub
		try {
			return roleMapperPro.addquanxian(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	/**
	 * 根据角色id删除所有角色权限
	 */
	@Override
	public int deletequanxian(int id) {
		// TODO Auto-generated method stub
		try {
			return roleMapperPro.deletequanxian(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

}
