package com.fintech.paysix.vo;

import java.util.Date;

public class StoreVO {

	private String sId;			//	업체번호
	private String sName;		//	업체명
	private String sAddr;		//	업체주소
	private String sTel;		//	업체전화
	private String sImgUrl;		//	업체대표이미지
	private String rName;		//	등록자명
	private Date inTime;		//	작성일시			default: current_timestamp

	public StoreVO() {
		super();
	}

	public StoreVO(String sId, String sName, String sAddr, String sTel, String sImgUrl, String rName, Date inTime) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sAddr = sAddr;
		this.sTel = sTel;
		this.sImgUrl = sImgUrl;
		this.rName = rName;
		this.inTime = inTime;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAddr() {
		return sAddr;
	}

	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}

	public String getsTel() {
		return sTel;
	}

	public void setsTel(String sTel) {
		this.sTel = sTel;
	}

	public String getsImgUrl() {
		return sImgUrl;
	}

	public void setsImgUrl(String sImgUrl) {
		this.sImgUrl = sImgUrl;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	@Override
	public String toString() {
		return "StoreVO [sId=" + sId + ", sName=" + sName + ", sAddr=" + sAddr + ", sTel=" + sTel + ", sImgUrl="
				+ sImgUrl + ", rName=" + rName + ", inTime=" + inTime + "]";
	}

}
