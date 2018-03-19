package cn.sdhqtj.hjt.entity;

public class Yaopinfenlei {
    private Integer id;

    private Integer jtid;

    private String flbh;

    private String flmc;

    private Short fldj;

    private Integer sjflid;

    private Integer zt;

    private String flbz;

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

    public String getFlbh() {
        return flbh;
    }

    public void setFlbh(String flbh) {
        this.flbh = flbh == null ? null : flbh.trim();
    }

    public String getFlmc() {
        return flmc;
    }

    public void setFlmc(String flmc) {
        this.flmc = flmc == null ? null : flmc.trim();
    }

    public Short getFldj() {
        return fldj;
    }

    public void setFldj(Short fldj) {
        this.fldj = fldj;
    }

    public Integer getSjflid() {
        return sjflid;
    }

    public void setSjflid(Integer sjflid) {
        this.sjflid = sjflid;
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public String getFlbz() {
        return flbz;
    }

    public void setFlbz(String flbz) {
        this.flbz = flbz == null ? null : flbz.trim();
    }
    
}