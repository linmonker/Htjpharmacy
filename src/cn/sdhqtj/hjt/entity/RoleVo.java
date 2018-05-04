package cn.sdhqtj.hjt.entity;

/**
 * 角色扩展类
 */
public class RoleVo extends Role {

	private String yhdlm; // 创建人用户名

	public String getYhdlm() {
		return yhdlm;
	}

	public void setYhdlm(String yhdlm) {
		this.yhdlm = yhdlm;
	}

	public String toExcelcol() {
		return getRole_name() + "," + getRemark() + "," + yhdlm + "," + getGmt_create() + "," + getGmt_modified() + ","
				+ (getZt() == 0 ? "启用" : "禁用");
	}

}
