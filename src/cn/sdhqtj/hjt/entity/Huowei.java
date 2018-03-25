package cn.sdhqtj.hjt.entity;

public class Huowei {
    private Integer id;

    private Integer jtid;

    private Integer fdid;

    private Integer ckid;

    private String hwbh;

    private String hwmc;

    private String hwmcjp;

    private Integer zt;

    private Integer dm;

    private String hwbz;

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

    public Integer getCkid() {
        return ckid;
    }

    public void setCkid(Integer ckid) {
        this.ckid = ckid;
    }

    public String getHwbh() {
        return hwbh;
    }

    public void setHwbh(String hwbh) {
        this.hwbh = hwbh == null ? null : hwbh.trim();
    }

    public String getHwmc() {
        return hwmc;
    }

    public void setHwmc(String hwmc) {
        this.hwmc = hwmc == null ? null : hwmc.trim();
    }

    public String getHwmcjp() {
        return hwmcjp;
    }

    public void setHwmcjp(String hwmcjp) {
        this.hwmcjp = hwmcjp == null ? null : hwmcjp.trim();
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

    public String getHwbz() {
        return hwbz;
    }

    public void setHwbz(String hwbz) {
        this.hwbz = hwbz == null ? null : hwbz.trim();
    }
}