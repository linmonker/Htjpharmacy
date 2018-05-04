package cn.sdhqtj.hjt.entity;

/**
 * 供应商扩展类
 */
public class GongyingshangVo extends GongyingshangWithBLOBs {

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
		return fdbh + "," + fdmc + "," + getGysbh() + "," + getGysmc() + "," + getGyslxdh() + "," + getGyslxr()
				+ "," + getGysxxdz() + "," + getGysywy() + "," + getGysywydh() + "," + getGysywysfz() + ","
				+ getGysyzbm() + "," + getGyslyxdz() + "," + getGysyyzz() + "," + getGysyyzzqx() + ","
				+ getGysyyzzfzrq() + "," + getGysfrdb() + "," + getGysjyxz() + "," + getGyszczb() + ","
				+ getGysjyfs() + "," + getGysjyfw() + "," + getGysscjyxkz() + "," + getGysxkzmc() + ","
				+ getGysxkzdz() + "," + getGysxkzbh() + "," + getGysxkzfzdw() + "," + getGysxkzyxq() + ","
				+ getGysxkzfzrq() + "," + getGysgspzj() + "," + getGysgspfzr() + "," + getGysgspzjyxq() + ","
				+ (getZt() == 0 ? "启用" : "禁用") + "," + getGysbz();
	}

}
