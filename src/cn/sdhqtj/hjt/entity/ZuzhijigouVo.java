package cn.sdhqtj.hjt.entity;

/**
 * 组织机构处室扩展类
 */
public class ZuzhijigouVo extends Zuzhijigou {

	private String fdbh; // 分店编号
	private String fdmc; // 分店名称

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

	public String toExcelcol() {
		return fdbh + "," + fdmc + "," + getCsbh() + "," + getCsmc() + "," + getCsmcjp() + "," + getCslxdh() + ","
				+ getCszr() + "," + (getZt() == 0 ? "启用" : "禁用") + "," + getCsbz();
	}

}
