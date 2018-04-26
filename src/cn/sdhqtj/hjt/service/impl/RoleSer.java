package cn.sdhqtj.hjt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.MenuNode;
import cn.sdhqtj.hjt.entity.Role;
import cn.sdhqtj.hjt.mapper.RoleMapper;
import cn.sdhqtj.hjt.mapper.RoleMapperPro;
import cn.sdhqtj.hjt.service.RoleService;

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
	public List<Role> getrole(Integer id) {
		// TODO Auto-generated method stub
		rolelist = roleMapperPro.getrole(id);
		return rolelist;
	}

	/**
	 * 根据角色id获取角色名称
	 */
	@Override
	public List<String> rolenamelist(Integer id) {
		// TODO Auto-generated method stub
		List<String> sl = roleMapperPro.rolenamelist(id);
		return sl;
	}

	/**
	 * 根据角色id获取相关权限url
	 */
	@Override
	public List<String> urllist(Integer id) {
		// TODO Auto-generated method stub
		List<String> sl = roleMapperPro.urllist(id);
		return sl;
	}

	/**
	 * 检查重复，角色名称
	 */
	@Override
	public List<Role> checkrepeat(Role record) {
		// TODO Auto-generated method stub
		rolelist = roleMapperPro.checkrepeat(record);
		return rolelist;
	}

	/**
	 * 添加角色
	 */
	@Override
	public void addrole(Role record) {
		// TODO Auto-generated method stub
		try {
			roleMapper.insertSelective(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 更新角色信息
	 */
	@Override
	public void updaterole(Role record) {
		// TODO Auto-generated method stub
		try {
			roleMapperPro.updaterole(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 根据角色id删除角色
	 */
	@Override
	public void deleterole(Integer id) {
		// TODO Auto-generated method stub
		role = new Role();
		role.setRole_id(id);
		role.setDm(1);
		roleMapper.updateByPrimaryKeySelective(role);

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
	 * 搜索角色
	 */
	@Override
	public List<Role> searchrole(Role record) {
		// TODO Auto-generated method stub
		rolelist = roleMapperPro.searchrole(record);
		return rolelist;
	}

}
