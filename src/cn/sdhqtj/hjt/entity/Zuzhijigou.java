package cn.sdhqtj.hjt.entity;

/**
 * 组织机构处室类
 */
public class Zuzhijigou {
	private Integer id;

	private Integer jtid;

	private Integer fdid;

	private String csbh;

	private String csmc;

	private String csmcjp;

	private String cslxdh;

	private String cszr;

	private Integer zt;

	private Integer dm;

	private String csbz;

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

	public String getCsbh() {
		return csbh;
	}

	public void setCsbh(String csbh) {
		this.csbh = csbh == null ? null : csbh.trim();
	}

	public String getCsmc() {
		return csmc;
	}

	public void setCsmc(String csmc) {
		this.csmc = csmc == null ? null : csmc.trim();
	}

	public String getCsmcjp() {
		return csmcjp;
	}

	public void setCsmcjp(String csmcjp) {
		this.csmcjp = csmcjp == null ? null : csmcjp.trim();
	}

	public String getCslxdh() {
		return cslxdh;
	}

	public void setCslxdh(String cslxdh) {
		this.cslxdh = cslxdh == null ? null : cslxdh.trim();
	}

	public String getCszr() {
		return cszr;
	}

	public void setCszr(String cszr) {
		this.cszr = cszr == null ? null : cszr.trim();
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

	public String getCsbz() {
		return csbz;
	}

	public void setCsbz(String csbz) {
		this.csbz = csbz == null ? null : csbz.trim();
	}
}