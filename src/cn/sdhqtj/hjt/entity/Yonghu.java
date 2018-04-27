package cn.sdhqtj.hjt.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户类
 */
public class Yonghu {
    private Integer id;

    private Integer jtid;

    private Integer fdid;

    private String yhbh;

    private String yhdlm;

    private String yhmm;

    private String yhxm;

    private String yhxmjp;

    private String yhxb;

    private String yhsfzh;

    private String yhsj;

    private String yhdzyx;

    private Integer yhbmid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    private Date yhcsrq;

    private String yhdz;

    private String yhyb;

    private Integer yhjsid;

    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date yhrzrq;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  
    private Date ct;

    private Integer zt;

    private Integer dm;

    private String yhbz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJtid() {
        return jtid;
    }

    public void setJtid(Integer jtid) {
        this.jtid = jtid;
    }

    public Integer getFdid() {
        return fdid;
    }

    public void setFdid(Integer fdid) {
        this.fdid = fdid;
    }

    public String getYhbh() {
        return yhbh;
    }

    public void setYhbh(String yhbh) {
        this.yhbh = yhbh == null ? null : yhbh.trim();
    }

    public String getYhdlm() {
        return yhdlm;
    }

    public void setYhdlm(String yhdlm) {
        this.yhdlm = yhdlm == null ? null : yhdlm.trim();
    }

    public String getYhmm() {
        return yhmm;
    }

    public void setYhmm(String yhmm) {
        this.yhmm = yhmm == null ? null : yhmm.trim();
    }

    public String getYhxm() {
        return yhxm;
    }

    public void setYhxm(String yhxm) {
        this.yhxm = yhxm == null ? null : yhxm.trim();
    }

    public String getYhxmjp() {
        return yhxmjp;
    }

    public void setYhxmjp(String yhxmjp) {
        this.yhxmjp = yhxmjp == null ? null : yhxmjp.trim();
    }

    public String getYhxb() {
        return yhxb;
    }

    public void setYhxb(String yhxb) {
        this.yhxb = yhxb == null ? null : yhxb.trim();
    }

    public String getYhsfzh() {
        return yhsfzh;
    }

    public void setYhsfzh(String yhsfzh) {
        this.yhsfzh = yhsfzh == null ? null : yhsfzh.trim();
    }

    public String getYhsj() {
        return yhsj;
    }

    public void setYhsj(String yhsj) {
        this.yhsj = yhsj == null ? null : yhsj.trim();
    }

    public String getYhdzyx() {
        return yhdzyx;
    }

    public void setYhdzyx(String yhdzyx) {
        this.yhdzyx = yhdzyx == null ? null : yhdzyx.trim();
    }

    public Integer getYhbmid() {
        return yhbmid;
    }

    public void setYhbmid(Integer yhbmid) {
        this.yhbmid = yhbmid;
    }

    public Date getYhcsrq() {
        return yhcsrq;
    }

    public void setYhcsrq(Date yhcsrq) {
		this.yhcsrq = yhcsrq;
    }

    public String getYhdz() {
        return yhdz;
    }

    public void setYhdz(String yhdz) {
        this.yhdz = yhdz == null ? null : yhdz.trim();
    }

    public String getYhyb() {
        return yhyb;
    }

    public void setYhyb(String yhyb) {
        this.yhyb = yhyb == null ? null : yhyb.trim();
    }

    public Integer getYhjsid() {
        return yhjsid;
    }

    public void setYhjsid(Integer yhjsid) {
        this.yhjsid = yhjsid;
    }

    public Date getYhrzrq() {
		return this.yhrzrq;
    }

    public void setYhrzrq(Date yhrzrq) {
		this.yhrzrq = yhrzrq;
    }

    public Date getCt() {
        return this.ct;
    }

    public void setCt(Date ct) {
		this.ct = ct;
    }

    public Integer getZt() {
        return this.zt;
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

    public String getYhbz() {
        return yhbz;
    }

    public void setYhbz(String yhbz) {
        this.yhbz = yhbz == null ? null : yhbz.trim();
    }
}