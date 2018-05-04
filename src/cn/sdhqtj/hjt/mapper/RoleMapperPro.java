package cn.sdhqtj.hjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sdhqtj.hjt.entity.AccessNode;
import cn.sdhqtj.hjt.entity.MenuNode;
import cn.sdhqtj.hjt.entity.Role;
import cn.sdhqtj.hjt.entity.RoleVo;

/**
 * 角色mapper补充
 */
public interface RoleMapperPro {

	/**
	 * 获取角色列表
	 */
	List<Role> rolequery();
	
	/**
	 * 获取角色Excel列表
	 */
	List<RoleVo> getexcellist();

	/**
	 * 根据角色id获取相关角色名称
	 */
	List<String> rolenamelist(int id);
	
	/**
	 * 检查重复：角色名称
	 */
	List<Role> checkrepeat(Role record);
	
	/**
	 * 模糊搜索角色：角色名称
	 */
	List<Role> searchrole(Role record);

	/**
	 * 添加角色,返回id
	 */
	int addrole(Role record);

	/**
	 * 更新角色信息
	 */
	int updaterole(Role record);
	
	/**
	 * 根据角色id获取相关权限url
	 */
	List<String> urllist(int id);

	/**
	 * 获取权限菜单
	 */
	List<MenuNode> getmenunodes();
	
	/**
	 * 根据角色id获取角色权限
	 */
	List<AccessNode> getquanxian(int roleid);
	
	/**
	 * 批量添加角色权限
	 */
	int addquanxian(@Param("list")List<AccessNode> list);
	
	/**
	 * 根据角色id删除所有角色权限
	 */
	int deletequanxian(int id);
}