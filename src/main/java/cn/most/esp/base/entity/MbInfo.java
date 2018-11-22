package cn.most.esp.base.entity;

public class MbInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int sid;

	private String scode;

	private String sname;

	private String smark;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSmark() {
		return smark;
	}

	public void setSmark(String smark) {
		this.smark = smark;
	}

}
