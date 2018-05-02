package cn.sdhqtj.hjt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.AccessNode;
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
	public Role getrole(Integer id) {
		// TODO Auto-generated method stub
		role = roleMapper.selectByPrimaryKey(id);
		return role;
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
	 * 检查重复，角色名称
	 */
	@Override
	public List<Role> checkrepeat(Role record) {
		// TODO Auto-generated method stub
		// 如果id为null，则设置id=-1，与数据库所有记录比较
		if (record.getRole_id() == null) {
			record.setRole_id(-1);
		}
		rolelist = roleMapperPro.checkrepeat(record);
		return rolelist;
	}

	/**
	 * 添加角色
	 */
	@Override
	public Integer addrole(Role record) {
		// TODO Auto-generated method stub
		Integer lastid = roleMapper.insertSelective(record);
		return lastid;
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
	 * 搜索角色
	 */
	@Override
	public List<Role> searchrole(Role record) {
		// TODO Auto-generated method stub
		rolelist = roleMapperPro.searchrole(record);
		return rolelist;
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
	public List<AccessNode> getquanxian(Integer id) {
		// TODO Auto-generated method stub
		List<AccessNode> alist = roleMapperPro.getquanxian(id);
		return alist;
	}

	/**
	 * 批量添加角色权限
	 */
	@Override
	public void addquanxian(List<AccessNode> list) {
		// TODO Auto-generated method stub
		try {
			roleMapperPro.addquanxian(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 根据角色id删除所有角色权限
	 */
	@Override
	public void deletequanxian(Integer id) {
		// TODO Auto-generated method stub
		roleMapperPro.deletequanxian(id);
	}

}
