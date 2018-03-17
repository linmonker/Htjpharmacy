package cn.sdhqtj.hjt.entity;

import java.math.BigDecimal;

public class Yisheng {
    private Long id;

    private Integer jtid;

    private String d_code;

    private Integer d_keshi;

    private String d_name;

    private String d_phone;

    private String d_headpic;

    private Integer d_sex;

    private Integer d_age;

    private String d_zhiwu;

    private Integer d_status;

    private BigDecimal d_ghf;

    private Integer uid;

    private String openid;

    private String token;

    private String d_jianjie;

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

    public String getD_code() {
        return d_code;
    }

    public void setD_code(String d_code) {
        this.d_code = d_code == null ? null : d_code.trim();
    }

    public Integer getD_keshi() {
        return d_keshi;
    }

    public void setD_keshi(Integer d_keshi) {
        this.d_keshi = d_keshi;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name == null ? null : d_name.trim();
    }

    public String getD_phone() {
        return d_phone;
    }

    public void setD_phone(String d_phone) {
        this.d_phone = d_phone == null ? null : d_phone.trim();
    }

    public String getD_headpic() {
        return d_headpic;
    }

    public void setD_headpic(String d_headpic) {
        this.d_headpic = d_headpic == null ? null : d_headpic.trim();
    }

    public Integer getD_sex() {
        return d_sex;
    }

    public void setD_sex(Integer d_sex) {
        this.d_sex = d_sex;
    }

    public Integer getD_age() {
        return d_age;
    }

    public void setD_age(Integer d_age) {
        this.d_age = d_age;
    }

    public String getD_zhiwu() {
        return d_zhiwu;
    }

    public void setD_zhiwu(String d_zhiwu) {
        this.d_zhiwu = d_zhiwu == null ? null : d_zhiwu.trim();
    }

    public Integer getD_status() {
        return d_status;
    }

    public void setD_status(Integer d_status) {
        this.d_status = d_status;
    }

    public BigDecimal getD_ghf() {
        return d_ghf;
    }

    public void setD_ghf(BigDecimal d_ghf) {
        this.d_ghf = d_ghf;
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

    public String getD_jianjie() {
        return d_jianjie;
    }

    public void setD_jianjie(String d_jianjie) {
        this.d_jianjie = d_jianjie == null ? null : d_jianjie.trim();
    }
}