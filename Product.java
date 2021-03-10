package model;

import java.util.Date;

public class Product {
	private	String pid;
	private String pname;
	private Integer	price;
	private Date	mfd;
	private byte[]	image;
	private String vid;
	public Product() {}
	public Product(String pid, String pname, Integer price, Date mfd, byte[] image, String vid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.mfd = mfd;
		this.image = image;
		this.vid = vid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getMfd() {
		return mfd;
	}
	public void setMfd(Date mfd) {
		this.mfd = mfd;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", mfd=" + mfd + ", image="
				+ image.length + ", vid=" + vid + "]";
	}
}
