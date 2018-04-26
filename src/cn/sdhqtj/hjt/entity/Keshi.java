package cn.sdhqtj.hjt.entity;

/**
 * 科室类
 */
public class Keshi {
	private Integer id;

	private Integer jtid;

	private Integer fdid;

	private String ksbh;

	private String ksmc;

	private String ksmcjp;

	private String kslxdh;

	private String kszr;

	private Integer zt;

	private Integer dm;

	private String ksbz;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getKsbh() {
		return ksbh;
	}

	public void setKsbh(String ksbh) {
		this.ksbh = ksbh == null ? null : ksbh.trim();
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc == null ? null : ksmc.trim();
	}

	public String getKsmcjp() {
		return ksmcjp;
	}

	public void setKsmcjp(String ksmcjp) {
		this.ksmcjp = ksmcjp == null ? null : ksmcjp.trim();
	}

	public String getKslxdh() {
		return kslxdh;
	}

	public void setKslxdh(String kslxdh) {
		this.kslxdh = kslxdh == null ? null : kslxdh.trim();
	}

	public String getKszr() {
		return kszr;
	}

	public void setKszr(String kszr) {
		this.kszr = kszr == null ? null : kszr.trim();
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

	public String getKsbz() {
		return ksbz;
	}

	public void setKsbz(String ksbz) {
		this.ksbz = ksbz == null ? null : ksbz.trim();
	}
}