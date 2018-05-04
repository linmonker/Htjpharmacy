package cn.sdhqtj.hjt.entity;

/**
 * 用户扩展类
 */
public class YonghuVo extends Yonghu {

	private String fdbh; // 分店编号
	private String fdmc; // 分店名称
	private String csmc; // 部门处室名称
	private String rolename; // 角色名称

	public String getFdbh() {
		return fdbh;
	}

	public void setFdbh(String fdbh) {
		this.fdbh = fdbh;
	}

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

	public String toExcelcol() {
		return fdbh + "," + fdmc + "," + getYhbh() + "," + getYhdlm() + "," + getYhxm() + "," + getYhxmjp() + "," + csmc
				+ "," + rolename + "," + ("1".equals(getYhxb()) ? "男" : "女") + "," + getYhsfzh() + "," + getYhsj() + ","
				+ getYhdzyx() + "," + getYhcsrq() + "," + getYhdz() + "," + getYhyb() + "," + getYhrzrq() + ","
				+ (getZt() == 0 ? "启用" : "禁用") + "," + getYhbz();
	}

}
