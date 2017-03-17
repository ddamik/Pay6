package com.fintech.paysix.vo;

import java.util.Date;

public class StoreVO {

	private String sid; // ��ü��ȣ
	private String sname; // ��ü��
	private String saddr; // ��ü�ּ�
	private String stel; // ��ü��ȭ
	private String simgurl; // ��ü��ǥ�̹���
	private String rname; // ����ڸ�
	private Date intime; // �ۼ��Ͻ� default: current_timestamp
	private String order_method; // �ֹ����: "0": ���̺� + ����ũ�ƿ� / "1": ���̺� / "2":
									// ����ũ �ƿ���
	private String bitcoin_addr; // ��Ʈ���� �ּ�

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

	public StoreVO(String sid, String sname, String saddr, String stel, String simgurl, String rname, Date intime,
			String order_method, String bitcoin_addr) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.saddr = saddr;
		this.stel = stel;
		this.simgurl = simgurl;
		this.rname = rname;
		this.intime = intime;
		this.order_method = order_method;
		this.bitcoin_addr = bitcoin_addr;
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

	public String getOrder_method() {
		return order_method;
	}

	public void setOrder_method(String order_method) {
		this.order_method = order_method;
	}

	public String getBitcoin_addr() {
		return bitcoin_addr;
	}

	public void setBitcoin_addr(String bitcoin_addr) {
		this.bitcoin_addr = bitcoin_addr;
	}

	@Override
	public String toString() {
		return "StoreVO [sid=" + sid + ", sname=" + sname + ", saddr=" + saddr + ", stel=" + stel + ", simgurl="
				+ simgurl + ", rname=" + rname + ", intime=" + intime + ", order_method=" + order_method
				+ ", bitcoin_addr=" + bitcoin_addr + "]";
	}

}
