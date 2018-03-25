package cn.sdhqtj.hjt.entity;

public class Login {
	private int id;
	private String login;
	private String password;
	private String createDate;
	private String loginDate;
	private String ip;
	private int fdid;
	private String fdmc;

	public Login() {
	}

	public Login(int id, String login, String password, String createDate, String loginDate, String ip) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.createDate = createDate;
		this.loginDate = loginDate;
		this.ip = ip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passWord) {
		this.password = passWord;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public int getFdid() {
		return fdid;
	}

	public void setFdid(int fdid) {
		this.fdid = fdid;
	}

	public String getFdmc() {
		return fdmc;
	}

	public void setFdmc(String fdmc) {
		this.fdmc = fdmc;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", login=" + login + ", password=" + password + ", createDate=" + createDate
				+ ", loginDate=" + loginDate + ", ip=" + ip + "]\n";
	}
}
