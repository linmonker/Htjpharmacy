package cn.sdhqtj.hjt.entity;

import java.util.Date;

public class Zljl {
    private Long ID;

    private Integer fdid;

    private Integer jtid;

    private String zlcode;

    private Long zlysid;

    private Integer hzid;

    private Date ct;

    private String zd;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Integer getFdid() {
        return fdid;
    }

    public void setFdid(Integer fdid) {
        this.fdid = fdid;
    }

    public Integer getJtid() {
        return jtid;
    }

    public void setJtid(Integer jtid) {
        this.jtid = jtid;
    }

    public String getZlcode() {
        return zlcode;
    }

    public void setZlcode(String zlcode) {
        this.zlcode = zlcode == null ? null : zlcode.trim();
    }

    public Long getZlysid() {
        return zlysid;
    }

    public void setZlysid(Long zlysid) {
        this.zlysid = zlysid;
    }

    public Integer getHzid() {
        return hzid;
    }

    public void setHzid(Integer hzid) {
        this.hzid = hzid;
    }

    public Date getCt() {
        return ct;
    }

    public void setCt(Date ct) {
        this.ct = ct;
    }

    public String getZd() {
        return zd;
    }

    public void setZd(String zd) {
        this.zd = zd == null ? null : zd.trim();
    }
}