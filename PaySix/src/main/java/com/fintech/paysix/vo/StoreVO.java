package com.fintech.paysix.vo;

import java.util.Date;

public class StoreVO {

	private String sid;			//	업체번호
	private String sname;		//	업체명
	private String saddr;		//	업체주소
	private String stel;		//	업체전화
	private String simgurl;		//	업체대표이미지
	private String rname;		//	등록자명
	private Date intime;		//	작성일시			default: current_timestamp

	public StoreVO() {
		super();
	}



	public StoreVO(String sid, String sname, String saddr, String stel, String simgurl, String rname) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.saddr = saddr;
		this.stel = stel;
		this.simgurl = simgurl;
		this.rname = rname;
	}



	public StoreVO(String sid, String sname, String saddr, String stel, String simgurl, String rname, Date intime) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.saddr = saddr;
		this.stel = stel;
		this.simgurl = simgurl;
		this.rname = rname;
		this.intime = intime;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddr() {
		return saddr;
	}

	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}

	public String getStel() {
		return stel;
	}

	public void setStel(String stel) {
		this.stel = stel;
	}

	public String getSimgurl() {
		return simgurl;
	}

	public void setSimgurl(String simgurl) {
		this.simgurl = simgurl;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	@Override
	public String toString() {
		return "StoreVO [sid=" + sid + ", sname=" + sname + ", saddr=" + saddr + ", stel=" + stel + ", simgurl="
				+ simgurl + ", rname=" + rname + ", intime=" + intime + "]";
	}



}
