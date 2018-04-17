package cn.sdhqtj.hjt.entity;

public class Login {
	private Integer id;
	private String username;
	private String password;
	private Integer fdid;
	private String fdmc;

	public Login() {
	}

	public Login(Integer id, String username, String password, Integer fdid, String fdmc) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fdid = fdid;
		this.fdmc = fdmc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getFdid() {
		return fdid;
	}

	public void setFdid(Integer fdid) {
		this.fdid = fdid;
	}

	public String getFdmc() {
		return fdmc;
	}

	public void setFdmc(String fdmc) {
		this.fdmc = fdmc;
	}

}
