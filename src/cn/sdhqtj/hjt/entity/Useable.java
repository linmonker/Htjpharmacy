package cn.sdhqtj.hjt.entity;

import java.util.Date;

public class Useable {
    private Integer id;

    private Integer jtid;

    private String useAble;

    private String url;

    private Date gmt_create;

    private Date gmt_modified;

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

    public String getUseAble() {
        return useAble;
    }

    public void setUseAble(String useAble) {
        this.useAble = useAble == null ? null : useAble.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }
}