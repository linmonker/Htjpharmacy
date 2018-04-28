package cn.sdhqtj.hjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sdhqtj.hjt.entity.AccessNode;
import cn.sdhqtj.hjt.entity.MenuNode;
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
	 * 根据角色id获取相关角色名称
	 */
	List<String> rolenamelist(Integer id);
	
	/**
	 * 检查重复，角色名称
	 */
	List<Role> checkrepeat(Role record);
	
	/**
	 * 添加角色,返回id
	 */
	Integer addrole(Role record);

	/**
	 * 搜索角色
	 */
	List<Role> searchrole(Role record);

	/**
	 * 更新角色信息
	 */
	void updaterole(Role record);
	
	/**
	 * 根据角色id获取相关权限url
	 */
	List<String> urllist(Integer id);

	/**
	 * 获取权限菜单
	 */
	List<MenuNode> getmenunodes();
	
	/**
	 * 根据角色id获取角色权限
	 */
	List<AccessNode> getquanxian(Integer id);
	
	/**
	 * 批量添加角色权限
	 */
	void addquanxian(@Param("list")List<AccessNode> list);
	
	/**
	 * 根据角色id删除所有角色权限
	 */
	void deletequanxian(Integer id);
}