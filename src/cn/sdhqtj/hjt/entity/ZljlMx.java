package cn.sdhqtj.hjt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ZljlMx {
	private Long ID;

	private Integer jtid;

	private Integer fdid;

	private Long zlid;

	private Integer ypid;

	private BigDecimal ypsl;

	private String jldw;

	private BigDecimal cfbs;

	private String mxbz;

	private Integer zt;

	private Integer dm;

	private Date ct;

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public Integer getJtid() {
		return jtid;
	}

	public void setJtid(Integer jtid) {
		this.jtid = jtid;
	}

	public Integer getFdid() {
		return fdid;
	}

	public void setFdid(Integer fdid) {
		this.fdid = fdid;
	}

	public Long getZlid() {
		return zlid;
	}

	public void setZlid(Long zlid) {
		this.zlid = zlid;
	}

	public Integer getYpid() {
		return ypid;
	}

	public void setYpid(Integer ypid) {
		this.ypid = ypid;
	}

	public BigDecimal getYpsl() {
		return ypsl;
	}

	public void setYpsl(BigDecimal ypsl) {
		this.ypsl = ypsl;
	}

	public String getJldw() {
		return jldw;
	}

	public void setJldw(String jldw) {
		this.jldw = jldw == null ? null : jldw.trim();
	}

	public BigDecimal getCfbs() {
		return cfbs;
	}

	public void setCfbs(BigDecimal cfbs) {
		this.cfbs = cfbs;
	}

	public String getMxbz() {
		return mxbz;
	}

	public void setMxbz(String mxbz) {
		this.mxbz = mxbz == null ? null : mxbz.trim();
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