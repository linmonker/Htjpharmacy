package cn.sdhqtj.hjt.entity;

/**
 * 货位扩展类
 */
public class HuoweiVo extends Huowei {

	private String fdbh; // 分店编号
	private String fdmc; // 分店名称
	private String ckbh; // 仓库编号
	private String ckmc; // 仓库名称

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

	public String getCkbh() {
		return ckbh;
	}

	public void setCkbh(String ckbh) {
		this.ckbh = ckbh;
	}

	public String getCkmc() {
		return ckmc;
	}

	public void setCkmc(String ckmc) {
		this.ckmc = ckmc;
	}

	public String toExcelcol() {
		return fdbh + "," + fdmc + "," + ckbh + "," + ckmc + "," + getHwbh() + "," + getHwmc() + ","
				+ (getZt() == 0 ? "启用" : "禁用") + "," + getHwbz();
	}

}
