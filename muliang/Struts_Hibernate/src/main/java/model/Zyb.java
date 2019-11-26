package model;

/**
 * Zyb entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Zyb implements java.io.Serializable {

	// Fields

	private Integer id;
	private String zym;
	private Integer rs;
	private String fzy;

	// Constructors

	/** default constructor */
	public Zyb() {
	}

	/** minimal constructor */
	public Zyb(Integer id, String zym) {
		this.id = id;
		this.zym = zym;
	}

	/** full constructor */
	public Zyb(Integer id, String zym, Integer rs, String fzy) {
		this.id = id;
		this.zym = zym;
		this.rs = rs;
		this.fzy = fzy;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getZym() {
		return this.zym;
	}

	public void setZym(String zym) {
		this.zym = zym;
	}

	public Integer getRs() {
		return this.rs;
	}

	public void setRs(Integer rs) {
		this.rs = rs;
	}

	public String getFzy() {
		return this.fzy;
	}

	public void setFzy(String fzy) {
		this.fzy = fzy;
	}

}