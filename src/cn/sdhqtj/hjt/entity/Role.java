package cn.sdhqtj.hjt.entity;

import java.text.ParseException;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 角色类
 */
public class Role {
	private Integer role_id;

	private Integer jtid;

	private String role_name;

	private Long user_id_create;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date gmt_create;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date gmt_modified;

	private Integer zt;

	private Integer dm;

	private String remark;

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getJtid() {
		return jtid;
	}

	public void setJtid(Integer jtid) {
		this.jtid = jtid;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name == null ? null : role_name.trim();
	}

	public Long getUser_id_create() {
		return user_id_create;
	}

	public void setUser_id_create(Long user_id_create) {
		this.user_id_create = user_id_create;
	}

	public Date getGmt_create() {
		return gmt_create;
	}

	public void setGmt_create(Date gmt_create) throws ParseException {
		this.gmt_create = gmt_create;
	}

	public Date getGmt_modified() {
		return gmt_modified;
	}

	public void setGmt_modified(Date gmt_modified) throws ParseException {
		this.gmt_modified = gmt_modified;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public Integer getDm() {
		return dm;
	}

	public void setDm(Integer dm) {
		this.dm = dm;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
}