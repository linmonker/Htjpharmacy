package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Role;

/**
 * 角色service接口
 */
@Service
public interface RoleService {

	/**
	 * 获取角色列表
	 */
	List<Role> rolequery();

	/**
	 * 根据角色id获取角色
	 */
	List<Role> getrole(Integer id);
	
	/**
	 * 根据角色id获取角色名称
	 */
	List<String> rolenamelist(Integer id);

	/**
	 * 根据角色id获取相关权限url
	 */
	List<String> urllist(Integer id);

	/**
	 * 检查重复，角色名称
	 */
	List<Role> checkrepeat(Role record);

	/**
	 * 添加角色
	 */
	void addrole(Role record);

	/**
	 * 更新角色信息
	 */
	void updaterole(Role record);

	/**
	 * 根据角色id删除角色
	 */
	void deleterole(Integer id);

}