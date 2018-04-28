package cn.sdhqtj.hjt.entity;

/**
 * 登录用户类
 */
public class Login {
	private Integer id;        // 用户id
	private String username;   // 用户名
	private String password;   // 用户密码
	private Integer fdid;      // 用户所属分店id
	private String fdmc;       // 用户所属分店名称

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
