package cn.sdhqtj.hjt.entity;

public class YaopinflNode {

	private Integer id;
	private Integer pId;
	private String name;
	private short levelid;
	private String flbz;

	public YaopinflNode() {
		// TODO Auto-generated constructor stub
	}

	public YaopinflNode(Integer id, Integer pId, String name, short levelid, String flbz) {
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.levelid = levelid;
		this.flbz = flbz;
	}

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
