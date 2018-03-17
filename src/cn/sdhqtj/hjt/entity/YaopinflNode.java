package cn.sdhqtj.hjt.entity;

public class YaopinflNode {

	private Integer id;
	private Integer pid;
	private String name;
	private short level_id;
	
	public YaopinflNode() {
		// TODO Auto-generated constructor stub
	}
	
	public YaopinflNode(Integer id, Integer pid, String name, short level_id) {
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.level_id = level_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getLevel_id() {
		return level_id;
	}

	public void setLevel_id(short level_id) {
		this.level_id = level_id;
	}
	
}
