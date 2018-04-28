package cn.sdhqtj.hjt.entity;

/**
 * 权限菜单类
 */
public class AccessNode {

	private Integer id;       // 节点id, 权限id(useableid)
	private Integer roleid;   // 角色id

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
}