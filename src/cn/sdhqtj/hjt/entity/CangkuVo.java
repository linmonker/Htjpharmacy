package cn.sdhqtj.hjt.entity;

/**
 * 仓库扩展类
 */
public class CangkuVo extends Cangku {

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
		return fdbh + "," + fdmc + "," + getCkbh() + "," + getCkmc() + "," + (getZt() == 0 ? "启用" : "禁用") + ","
				+ getCkbz();
	}

}
