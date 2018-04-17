package cn.sdhqtj.hjt.entity;

/**
 * 用户扩展类
 */
public class YonghuPro extends Yonghu {

	private String fdmc;
	
	private String csmc;
	
	private String rolename;

	public String getFdmc() {
		return fdmc;
	}

	public void setFdmc(String fdmc) {
		this.fdmc = fdmc;
	}

	public String getCsmc() {
		return csmc;
	}

	public void setCsmc(String csmc) {
		this.csmc = csmc;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
