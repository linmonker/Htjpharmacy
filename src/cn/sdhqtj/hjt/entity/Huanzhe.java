package cn.sdhqtj.hjt.entity;

import java.util.Date;

public class Huanzhe {
    private Long id;

    private Integer jtid;

    private String u_code;

    private String u_name;

    private String u_phone;

    private String u_password;

    private String u_sfzhm;

    private Integer u_sex;

    private Date u_csrq;

    private String u_yzbm;

    private String u_jtzz;

    private String u_zhiye;

    private Integer u_status;

    private Date u_ct;

    private Integer uid;

    private String openid;

    private String token;

    private String u_jianjie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getJtid() {
        return jtid;
    }

    public void setJtid(Integer jtid) {
        this.jtid = jtid;
    }

    public String getU_code() {
        return u_code;
    }

    public void setU_code(String u_code) {
        this.u_code = u_code == null ? null : u_code.trim();
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name == null ? null : u_name.trim();
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone == null ? null : u_phone.trim();
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password == null ? null : u_password.trim();
    }

    public String getU_sfzhm() {
        return u_sfzhm;
    }

    public void setU_sfzhm(String u_sfzhm) {
        this.u_sfzhm = u_sfzhm == null ? null : u_sfzhm.trim();
    }

    public Integer getU_sex() {
        return u_sex;
    }

    public void setU_sex(Integer u_sex) {
        this.u_sex = u_sex;
    }

    public Date getU_csrq() {
        return u_csrq;
    }

    public void setU_csrq(Date u_csrq) {
        this.u_csrq = u_csrq;
    }

    public String getU_yzbm() {
        return u_yzbm;
    }

    public void setU_yzbm(String u_yzbm) {
        this.u_yzbm = u_yzbm == null ? null : u_yzbm.trim();
    }

    public String getU_jtzz() {
        return u_jtzz;
    }

    public void setU_jtzz(String u_jtzz) {
        this.u_jtzz = u_jtzz == null ? null : u_jtzz.trim();
    }

    public String getU_zhiye() {
        return u_zhiye;
    }

    public void setU_zhiye(String u_zhiye) {
        this.u_zhiye = u_zhiye == null ? null : u_zhiye.trim();
    }

    public Integer getU_status() {
        return u_status;
    }

    public void setU_status(Integer u_status) {
        this.u_status = u_status;
    }

    public Date getU_ct() {
        return u_ct;
    }

    public void setU_ct(Date u_ct) {
        this.u_ct = u_ct;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getU_jianjie() {
        return u_jianjie;
    }

    public void setU_jianjie(String u_jianjie) {
        this.u_jianjie = u_jianjie == null ? null : u_jianjie.trim();
    }
}