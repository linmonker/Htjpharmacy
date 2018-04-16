package cn.sdhqtj.hjt.entity;

public class Login {
	private int id;
	private String login;
	private String password;
	private String loginDate;
	private int fdid;
	private String fdmc;

	public Login() {
	}

	public Login(int id, String login, String password, String loginDate, int fdid, String fdmc) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.loginDate = loginDate;
		this.fdid = fdid;
		this.fdmc = fdmc;
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
	
	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
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
}
