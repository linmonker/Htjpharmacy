package cn.sdhqtj.hjt.entity;

/**
 * 仓库类
 */
public class Cangku {
    private Integer id;

    private Integer jtid;

    private Integer fdid;

    private String ckbh;

    private String ckmc;

    private String ckmcjp;

    private Integer zt;

    private Integer dm;

    private String ckbz;

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

    public String getCkbh() {
        return ckbh;
    }

    public void setCkbh(String ckbh) {
        this.ckbh = ckbh == null ? null : ckbh.trim();
    }

    public String getCkmc() {
        return ckmc;
    }

    public void setCkmc(String ckmc) {
        this.ckmc = ckmc == null ? null : ckmc.trim();
    }

    public String getCkmcjp() {
        return ckmcjp;
    }

    public void setCkmcjp(String ckmcjp) {
        this.ckmcjp = ckmcjp == null ? null : ckmcjp.trim();
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

    public String getCkbz() {
        return ckbz;
    }

    public void setCkbz(String ckbz) {
        this.ckbz = ckbz == null ? null : ckbz.trim();
    }
	
}