package cn.sdhqtj.hjt.entity;

/**
 *
 */
public class YaopinPro extends YaopinWithBLOBs {
	private String flmc;
	private String gysmc;
	
	public YaopinPro() {
	}

	public YaopinPro(String flmc, String gysmc) {
		this.flmc = flmc;
		this.gysmc = gysmc;
	}

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