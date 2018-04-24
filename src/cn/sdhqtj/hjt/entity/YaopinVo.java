package cn.sdhqtj.hjt.entity;

/**
 * 药品扩展类
 */
public class YaopinVo extends YaopinWithBLOBs {
	private String flmc; // 分店名称
	private String gysmc; // 供应商名称
	
	public String getFlmc() {
		return flmc;
	}

	public void setFlmc(String flmc) {
		this.flmc = flmc;
	}

	public String getGysmc() {
		return gysmc;
	}

	public void setGysmc(String gysmc) {
		this.gysmc = gysmc;
	}
	
}