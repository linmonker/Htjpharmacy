package cn.sdhqtj.hjt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class XsdjMx {
	private Long ID;

	private Integer jtid;

	private Integer fdid;

	private Integer djid;

	private String xmlx;

	private Integer hzid;

	private Integer ypid;

	private BigDecimal ypsl;

	private String ypdw;

	private String ypph;

	private String ypcd;

	private BigDecimal hjje;

	private BigDecimal ssje;

	private String xmbz;

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

	public Integer getDjid() {
		return djid;
	}

	public void setDjid(Integer djid) {
		this.djid = djid;
	}

	public String getXmlx() {
		return xmlx;
	}

	public void setXmlx(String xmlx) {
		this.xmlx = xmlx == null ? null : xmlx.trim();
	}

	public Integer getHzid() {
		return hzid;
	}

	public void setHzid(Integer hzid) {
		this.hzid = hzid;
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

	public String getYpph() {
		return ypph;
	}

	public void setYpph(String ypph) {
		this.ypph = ypph == null ? null : ypph.trim();
	}

	public String getYpcd() {
		return ypcd;
	}

	public void setYpcd(String ypcd) {
		this.ypcd = ypcd == null ? null : ypcd.trim();
	}

	public BigDecimal getHjje() {
		return hjje;
	}

	public void setHjje(BigDecimal hjje) {
		this.hjje = hjje;
	}

	public BigDecimal getSsje() {
		return ssje;
	}

	public void setSsje(BigDecimal ssje) {
		this.ssje = ssje;
	}

	public String getXmbz() {
		return xmbz;
	}

	public void setXmbz(String xmbz) {
		this.xmbz = xmbz == null ? null : xmbz.trim();
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