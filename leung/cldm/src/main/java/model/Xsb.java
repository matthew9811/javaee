package model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class Xsb implements java.io.Serializable {
	private String xh;
	private Zyb zyb;
	private String xm;
	private Byte xb;
	private Date cssj;
	private Integer zxf;
	private String bz;
	private byte[] zp;
	private Set kcs=new HashSet();
	// ʡ���������Ե�get��set����
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public Zyb getZyb() {
		return zyb;
	}
	public void setZyb(Zyb zyb) {
		this.zyb = zyb;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public Byte getXb() {
		return xb;
	}
	public void setXb(Byte xb) {
		this.xb = xb;
	}
	public Date getCssj() {
		return cssj;
	}
	public void setCssj(Date cssj) {
		this.cssj = cssj;
	}
	public Integer getZxf() {
		return zxf;
	}
	public void setZxf(Integer zxf) {
		this.zxf = zxf;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public byte[] getZp() {
		return zp;
	}
	public void setZp(byte[] zp) {
		this.zp = zp;
	}
	public Set getKcs() {
		return kcs;
	}
	public void setKcs(Set kcs) {
		this.kcs = kcs;
	}
}
