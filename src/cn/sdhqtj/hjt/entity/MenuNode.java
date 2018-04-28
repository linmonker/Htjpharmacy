package cn.sdhqtj.hjt.entity;

/**
 * 权限菜单节点类
 */
public class MenuNode {

	private Integer id;  // 节点id
	private Integer pId; // 父节点id
	private String name; // 节点名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
