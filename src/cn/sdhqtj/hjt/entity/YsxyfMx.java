package cn.sdhqtj.hjt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class YsxyfMx {
	private Integer ID;

	private Integer xyfid;

	private Integer ypid;

	private BigDecimal ypsl;

	private String ypdw;

	private String ypbz;

	private Integer zt;

	private Integer dm;

	private Date ct;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public Integer getXyfid() {
		return xyfid;
	}

	public void setXyfid(Integer xyfid) {
		this.xyfid = xyfid;
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

	public String getYpdw() {
		return ypdw;
	}

	public void setYpdw(String ypdw) {
		this.ypdw = ypdw == null ? null : ypdw.trim();
	}

	public String getYpbz() {
		return ypbz;
	}

	public void setYpbz(String ypbz) {
		this.ypbz = ypbz == null ? null : ypbz.trim();
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