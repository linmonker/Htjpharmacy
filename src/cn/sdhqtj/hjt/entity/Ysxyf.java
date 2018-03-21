package cn.sdhqtj.hjt.entity;

import java.util.Date;

public class Ysxyf {
	private Integer ID;

	private Integer fdid;

	private Integer jtid;

	private String xyfbm;

	private String xyfmc;

	private String xyfzjm;

	private Long ysid;

	private Integer zt;

	private Integer dm;

	private Date ct;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public Integer getFdid() {
		return fdid;
	}

	public void setFdid(Integer fdid) {
		this.fdid = fdid;
	}

	public Integer getJtid() {
		return jtid;
	}

	public void setJtid(Integer jtid) {
		this.jtid = jtid;
	}

	public String getXyfbm() {
		return xyfbm;
	}

	public void setXyfbm(String xyfbm) {
		this.xyfbm = xyfbm == null ? null : xyfbm.trim();
	}

	public String getXyfmc() {
		return xyfmc;
	}

	public void setXyfmc(String xyfmc) {
		this.xyfmc = xyfmc == null ? null : xyfmc.trim();
	}

	public String getXyfzjm() {
		return xyfzjm;
	}

	public void setXyfzjm(String xyfzjm) {
		this.xyfzjm = xyfzjm == null ? null : xyfzjm.trim();
	}

	public Long getYsid() {
		return ysid;
	}

	public void setYsid(Long ysid) {
		this.ysid = ysid;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public Integer getDm() {
		return dm;
	}

	public void setDm(Integer dm) {
		this.dm = dm;
	}

	public Date getCt() {
		return ct;
	}

	public void setCt(Date ct) {
		this.ct = ct;
	}
}