package cn.sdhqtj.hjt.entity;

/**
 * 药品扩展类
 */
public class YaopinVo extends YaopinWithBLOBs {

	private String flmc; // 分类名称
	private String gysbh; // 供应商编号
	private String gysmc; // 供应商名称
	private String yhdlm; // 药品创建人用户名

	public String getFlmc() {
		return flmc;
	}

	public void setFlmc(String flmc) {
		this.flmc = flmc;
	}

	public String getGysmc() {
		return gysmc;
	}

	public String getGysbh() {
		return gysbh;
	}

	public void setGysbh(String gysbh) {
		this.gysbh = gysbh;
	}

	public void setGysmc(String gysmc) {
		this.gysmc = gysmc;
	}

	public String getYhdlm() {
		return yhdlm;
	}

	public void setYhdlm(String yhdlm) {
		this.yhdlm = yhdlm;
	}

	public String toExcelcol() {
		return getYpbh() + "," + getYpspm() + "," + getYptym() + "," + flmc + "," + gysbh + "," + gysmc + ","
				+ getYpgg() + "," + getYpbzgg() + "," + getYpcd() + "," + getYpzddcgml() + "," + getYpsx() + ","
				+ (getYpyytx() == 0 ? "开方提醒" : "不提醒") + "," + getYpyytxnr() + "," + getYpscdw() + "," + getYpjx() + ","
				+ getYpdw() + "," + getYpzcsb() + "," + getYppzwh() + "," + getYpysbz() + "," + getYpcctj() + ","
				+ getYpjhj() + "," + getYppfj() + "," + getYplsj() + "," + getYphyj() + "," + getYpyxq() + ","
				+ getYpkcxx() + "," + getYpkcsx() + ","
				+ (getYpshzt() == 0 ? "未审核" : (getYpshzt() == 1 ? "已审核" : "审核不通过")) + "," + getYpyhzq() + ","
				+ getYpsms() + "," + getYpxf() + "," + getYpxw() + "," + (getYpsfdz() == 0 ? "允许打折" : "禁止打折") + ","
				+ (getYpsfcyhyjf() == 0 ? "参与积分" : "不参与") + "," + getYpkcsl() + "," + yhdlm + ", " + getCt() + ","
				+ (getZt() == 0 ? "启用" : "禁用");
	}

}