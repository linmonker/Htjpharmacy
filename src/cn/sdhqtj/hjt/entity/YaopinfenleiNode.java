package cn.sdhqtj.hjt.entity;

/**
 * 药品分类节点类
 */
public class YaopinfenleiNode {

	private Integer id;     // 节点id,药品id
	private Integer pId;    // 父节点id
	private String name;    // 节点名称
	private short levelid;  // 节点等级，tree0开始，数据库1开始
	private String flbz;    // 备注信息

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

	public short getLevelid() {
		return levelid;
	}

	public void setLevelid(short levelid) {
		this.levelid = levelid;
	}

	public String getFlbz() {
		return flbz;
	}

	public void setFlbz(String flbz) {
		this.flbz = flbz;
	}

}
