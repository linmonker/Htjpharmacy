package cn.sdhqtj.hjt.entity;

/**
 * 药品分类扩展类
 */
public class YaopinfenleiVo extends Yaopinfenlei {

	private String sjflmc; // 上级分类名称

	public String getSjflmc() {
		return sjflmc;
	}

	public void setSjflmc(String sjflmc) {
		this.sjflmc = sjflmc;
	}

	public String toExcelcol() {
		return getFlbh() + "," + getFlmc() + "," + sjflmc + "," + getFldj() + "," + getFlbz();
	}

}
