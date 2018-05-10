package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.AccessNode;
import cn.sdhqtj.hjt.entity.MenuNode;
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
	 * 获取角色列表，从start开始20条记录
	 */
	List<Role> getlist(int start);

	/**
	 * 获取角色列表记录数
	 */
	int getcount();

	/**
	 * 模糊搜索角色：角色名称，从start开始20条记录
	 */
	List<Role> searchrole(Role record, int start);

	/**
	 * 搜索角色列表记录数
	 */
	int getsearchcount(Role record);

	/**
	 * 检查重复：角色名称
	 */
	List<Role> checkrepeat(Role record);

	/**
	 * 根据角色id获取角色名称
	 */
	List<String> rolenamelist(int id);

	/**
	 * 根据角色id获取角色
	 */
	Role getrole(int id);

	/**
	 * 添加角色,返回id
	 */
	int addrole(Role record);

	/**
	 * 更新角色信息
	 */
	int updaterole(Role record);

	/**
	 * 根据角色id删除角色
	 */
	int deleterole(Integer id);

	/**
	 * 生成角色列表Excel，返回文件路径
	 */
	public String writeexcel();

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
	List<AccessNode> getquanxian(int id);

	/**
	 * 批量添加角色权限
	 */
	int addquanxian(List<AccessNode> list);

	/**
	 * 根据角色id删除所有角色权限
	 */
	int deletequanxian(int id);

}