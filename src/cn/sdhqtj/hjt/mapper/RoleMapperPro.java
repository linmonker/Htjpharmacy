package cn.sdhqtj.hjt.mapper;

import java.util.List;

import cn.sdhqtj.hjt.entity.Role;

/**
 * 角色mapper补充
 */
public interface RoleMapperPro {

	/**
	 * 获取角色列表
	 */
	List<Role> rolequery();

	/**
	 * 根据角色id获取角色
	 */
	List<Role> getrole(Integer id);

	/**
	 * 根据角色id获取相关角色名称
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
	 * 更新角色信息
	 */
	void updaterole(Role record);
}