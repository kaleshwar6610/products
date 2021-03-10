package model;

import java.util.Date;

public class Vendor {
	private String vid;
	private String vname;
	private Date arrivalDate;
	public Vendor() {}
	public Vendor(String vid, String vname, Date arrivalDate) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.arrivalDate = arrivalDate;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", vname=" + vname + ", arrivalDate=" + arrivalDate + "]";
	};
}
