package cn.sdhqtj.hjt.entity;

/**
 * 供应商完整类
 */
public class GongyingshangWithBLOBs extends Gongyingshang {
	private String gysjyfw;

	private String gysbz;

	public String getGysjyfw() {
		return gysjyfw;
	}

	public void setGysjyfw(String gysjyfw) {
		this.gysjyfw = gysjyfw == null ? null : gysjyfw.trim();
	}

	public String getGysbz() {
		return gysbz;
	}

	public void setGysbz(String gysbz) {
		this.gysbz = gysbz == null ? null : gysbz.trim();
	}
}