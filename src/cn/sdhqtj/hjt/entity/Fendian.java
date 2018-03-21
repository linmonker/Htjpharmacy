package cn.sdhqtj.hjt.entity;

public class Fendian {
	private Integer id;

	private Integer jtid;

	private String fdbh;

	private String fdmc;

	private String fddz;

	private String fdlxdh;

	private String fddzxm;

	private Integer zt;

	private String fdbz;

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

	public String getFdbh() {
		return fdbh;
	}

	public void setFdbh(String fdbh) {
		this.fdbh = fdbh == null ? null : fdbh.trim();
	}

	public String getFdmc() {
		return fdmc;
	}

	public void setFdmc(String fdmc) {
		this.fdmc = fdmc == null ? null : fdmc.trim();
	}

	public String getFddz() {
		return fddz;
	}

	public void setFddz(String fddz) {
		this.fddz = fddz == null ? null : fddz.trim();
	}

	public String getFdlxdh() {
		return fdlxdh;
	}

	public void setFdlxdh(String fdlxdh) {
		this.fdlxdh = fdlxdh == null ? null : fdlxdh.trim();
	}

	public String getFddzxm() {
		return fddzxm;
	}

	public void setFddzxm(String fddzxm) {
		this.fddzxm = fddzxm == null ? null : fddzxm.trim();
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getFdbz() {
		return fdbz;
	}

	public void setFdbz(String fdbz) {
		this.fdbz = fdbz == null ? null : fdbz.trim();
	}

	@Override
	public String toString() {
		return "Fendian [id=" + id + ", jtid=" + jtid + ", fdbh=" + fdbh + ", fdmc=" + fdmc + ", fddz=" + fddz
				+ ", fdlxdh=" + fdlxdh + ", fddzxm=" + fddzxm + ", zt=" + zt + ", fdbz=" + fdbz + "]";
	}

}