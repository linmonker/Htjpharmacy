package cn.sdhqtj.hjt.entity;

/**
 * 药品分类
 */
public class YaopinWithBLOBs extends Yaopin {
	private String ypsms;

	private String ypxf;

	private String ypxw;

	public String getYpsms() {
		return ypsms;
	}

	public void setYpsms(String ypsms) {
		this.ypsms = ypsms == null ? null : ypsms.trim();
	}

	public String getYpxf() {
		return ypxf;
	}

	public void setYpxf(String ypxf) {
		this.ypxf = ypxf == null ? null : ypxf.trim();
	}

	public String getYpxw() {
		return ypxw;
	}

	public void setYpxw(String ypxw) {
		this.ypxw = ypxw == null ? null : ypxw.trim();
	}
}