package model;
import java.util.HashSet;
import java.util.Set;
public class Kcb implements java.io.Serializable {
	private String kch;
	private String kcm;
	private Short kxxq;
	private int xs;
	private int xf;
	private Set xss=new HashSet();
	//ʡ���������Ե�set��get����
	public String getKch() {
		return kch;
	}
	public void setKch(String kch) {
		this.kch = kch;
	}
	public String getKcm() {
		return kcm;
	}
	public void setKcm(String kcm) {
		this.kcm = kcm;
	}
	public Short getKxxq() {
		return kxxq;
	}
	public void setKxxq(Short kxxq) {
		this.kxxq = kxxq;
	}
	public int getXs() {
		return xs;
	}
	public void setXs(int xs) {
		this.xs = xs;
	}
	public int getXf() {
		return xf;
	}
	public void setXf(int xf) {
		this.xf = xf;
	}
	public Set getXss() {
		return xss;
	}
	public void setXss(Set xss) {
		this.xss = xss;
	}
}
