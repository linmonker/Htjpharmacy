package cn.sdhqtj.hjt.entity;

public class YaopinflNode {

	private Integer id;
	private Integer pId;
	private String name;
	private short levelid;

	public YaopinflNode() {
		// TODO Auto-generated constructor stub
	}

	public YaopinflNode(Integer id, Integer pId, String name, short levelid) {
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.levelid = levelid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPId() {
		return pId;
	}

	public void setPId(Integer pId) {
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

}
