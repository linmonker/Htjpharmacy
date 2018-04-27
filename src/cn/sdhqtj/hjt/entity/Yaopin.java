package cn.sdhqtj.hjt.entity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 药品缺类
 */
public class Yaopin {
	private Integer id;

	private Integer jtid;

	private Integer yplb;

	private Integer ypgys;

	private String ypbh;

	private String ypspm;

	private String yptym;

	private String ypgg;

	private String ypbzgg;

	private String ypcd;

	private BigDecimal ypzddcgml;

	private String ypsx;

	private Integer ypyytx;

	private String ypyytxnr;

	private String ypscdw;

	private String ypjx;

	private String ypdw;

	private String ypzcsb;

	private String yppzwh;

	private String ypysbz;

	private String ypcctj;

	private BigDecimal ypjhj;

	private BigDecimal yppfj;

	private BigDecimal yplsj;

	private BigDecimal yphyj;

	private String ypyxq;

	private BigDecimal ypkcxx;

	private BigDecimal ypkcsx;

	private Integer ypshzt;

	private Integer ypyhzq;

	private Integer ypsfdz;

	private Integer ypsfcyhyjf;

	private String ypcwbj1;

	private String ypcwbj2;

	private Integer ypcjr;

	private BigDecimal ypkcsl;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date ct;

	private Integer zt;

	private Integer dm;

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

	public Integer getYplb() {
		return yplb;
	}

	public void setYplb(Integer yplb) {
		this.yplb = yplb;
	}

	public Integer getYpgys() {
		return ypgys;
	}

	public void setYpgys(Integer ypgys) {
		this.ypgys = ypgys;
	}

	public String getYpbh() {
		return ypbh;
	}

	public void setYpbh(String ypbh) {
		this.ypbh = ypbh == null ? null : ypbh.trim();
	}

	public String getYpspm() {
		return ypspm;
	}

	public void setYpspm(String ypspm) {
		this.ypspm = ypspm == null ? null : ypspm.trim();
	}

	public String getYptym() {
		return yptym;
	}

	public void setYptym(String yptym) {
		this.yptym = yptym == null ? null : yptym.trim();
	}

	public String getYpgg() {
		return ypgg;
	}

	public void setYpgg(String ypgg) {
		this.ypgg = ypgg == null ? null : ypgg.trim();
	}

	public String getYpbzgg() {
		return ypbzgg;
	}

	public void setYpbzgg(String ypbzgg) {
		this.ypbzgg = ypbzgg == null ? null : ypbzgg.trim();
	}

	public String getYpcd() {
		return ypcd;
	}

	public void setYpcd(String ypcd) {
		this.ypcd = ypcd == null ? null : ypcd.trim();
	}

	public BigDecimal getYpzddcgml() {
		return ypzddcgml;
	}

	public void setYpzddcgml(BigDecimal ypzddcgml) {
		this.ypzddcgml = ypzddcgml;
	}

	public String getYpsx() {
		return ypsx;
	}

	public void setYpsx(String ypsx) {
		this.ypsx = ypsx == null ? null : ypsx.trim();
	}

	public Integer getYpyytx() {
		return ypyytx;
	}

	public void setYpyytx(Integer ypyytx) {
		this.ypyytx = ypyytx;
	}

	public String getYpyytxnr() {
		return ypyytxnr;
	}

	public void setYpyytxnr(String ypyytxnr) {
		this.ypyytxnr = ypyytxnr == null ? null : ypyytxnr.trim();
	}

	public String getYpscdw() {
		return ypscdw;
	}

	public void setYpscdw(String ypscdw) {
		this.ypscdw = ypscdw == null ? null : ypscdw.trim();
	}

	public String getYpjx() {
		return ypjx;
	}

	public void setYpjx(String ypjx) {
		this.ypjx = ypjx == null ? null : ypjx.trim();
	}

	public String getYpdw() {
		return ypdw;
	}

	public void setYpdw(String ypdw) {
		this.ypdw = ypdw == null ? null : ypdw.trim();
	}

	public String getYpzcsb() {
		return ypzcsb;
	}

	public void setYpzcsb(String ypzcsb) {
		this.ypzcsb = ypzcsb == null ? null : ypzcsb.trim();
	}

	public String getYppzwh() {
		return yppzwh;
	}

	public void setYppzwh(String yppzwh) {
		this.yppzwh = yppzwh == null ? null : yppzwh.trim();
	}

	public String getYpysbz() {
		return ypysbz;
	}

	public void setYpysbz(String ypysbz) {
		this.ypysbz = ypysbz == null ? null : ypysbz.trim();
	}

	public String getYpcctj() {
		return ypcctj;
	}

	public void setYpcctj(String ypcctj) {
		this.ypcctj = ypcctj == null ? null : ypcctj.trim();
	}

	public BigDecimal getYpjhj() {
		return ypjhj;
	}

	public void setYpjhj(BigDecimal ypjhj) {
		this.ypjhj = ypjhj;
	}

	public BigDecimal getYppfj() {
		return yppfj;
	}

	public void setYppfj(BigDecimal yppfj) {
		this.yppfj = yppfj;
	}

	public BigDecimal getYplsj() {
		return yplsj;
	}

	public void setYplsj(BigDecimal yplsj) {
		this.yplsj = yplsj;
	}

	public BigDecimal getYphyj() {
		return yphyj;
	}

	public void setYphyj(BigDecimal yphyj) {
		this.yphyj = yphyj;
	}

	public String getYpyxq() {
		return ypyxq;
	}

	public void setYpyxq(String ypyxq) {
		this.ypyxq = ypyxq == null ? null : ypyxq.trim();
	}

	public BigDecimal getYpkcxx() {
		return ypkcxx;
	}

	public void setYpkcxx(BigDecimal ypkcxx) {
		this.ypkcxx = ypkcxx;
	}

	public BigDecimal getYpkcsx() {
		return ypkcsx;
	}

	public void setYpkcsx(BigDecimal ypkcsx) {
		this.ypkcsx = ypkcsx;
	}

	public Integer getYpshzt() {
		return ypshzt;
	}

	public void setYpshzt(Integer ypshzt) {
		this.ypshzt = ypshzt;
	}

	public Integer getYpyhzq() {
		return ypyhzq;
	}

	public void setYpyhzq(Integer ypyhzq) {
		this.ypyhzq = ypyhzq;
	}

	public Integer getYpsfdz() {
		return ypsfdz;
	}

	public void setYpsfdz(Integer ypsfdz) {
		this.ypsfdz = ypsfdz;
	}

	public Integer getYpsfcyhyjf() {
		return ypsfcyhyjf;
	}

	public void setYpsfcyhyjf(Integer ypsfcyhyjf) {
		this.ypsfcyhyjf = ypsfcyhyjf;
	}

	public String getYpcwbj1() {
		return ypcwbj1;
	}

	public void setYpcwbj1(String ypcwbj1) {
		this.ypcwbj1 = ypcwbj1 == null ? null : ypcwbj1.trim();
	}

	public String getYpcwbj2() {
		return ypcwbj2;
	}

	public void setYpcwbj2(String ypcwbj2) {
		this.ypcwbj2 = ypcwbj2 == null ? null : ypcwbj2.trim();
	}

	public Integer getYpcjr() {
		return ypcjr;
	}

	public void setYpcjr(Integer ypcjr) {
		this.ypcjr = ypcjr;
	}

	public BigDecimal getYpkcsl() {
		return ypkcsl;
	}

	public void setYpkcsl(BigDecimal ypkcsl) {
		this.ypkcsl = ypkcsl;
	}

	public Date getCt() {
		return ct;
	}

	public void setCt(Date ct) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String dd = sdf.format(ct);
		this.ct = sdf.parse(dd);
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
}