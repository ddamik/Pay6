package com.fintech.paysix.vo;

import java.util.Date;

public class LogVO {

	private int seqid; // 로그 일련번호
	private int tno; // 테이블 번호
	private int orderno; // 주문 번호
	private String status; // 주문 진행상황
	private String pid; // 상품번호
	private String userid; // 주문자 아이디
	private String paymethod; // 결제 수단
	private Date ordertime; // 주문 시간 default: current_timestamp
	private Date endtime; // 처리 시간
	private int etc1; // 부가 1 default: 0
	private int etc2; // 부가 2 default: 0

	public LogVO() {
		super();
	}

	public LogVO(int tno, int orderno, String status, String pid, String userid, String paymethod, Date endtime) {
		super();
		this.tno = tno;
		this.orderno = orderno;
		this.status = status;
		this.pid = pid;
		this.userid = userid;
		this.paymethod = paymethod;
		this.endtime = endtime;
	}

	public LogVO(int seqid, int tno, int orderno, String status, String pid, String userid, String paymethod,
			Date ordertime, Date endtime, int etc1, int etc2) {
		super();
		this.seqid = seqid;
		this.tno = tno;
		this.orderno = orderno;
		this.status = status;
		this.pid = pid;
		this.userid = userid;
		this.paymethod = paymethod;
		this.ordertime = ordertime;
		this.endtime = endtime;
		this.etc1 = etc1;
		this.etc2 = etc2;
	}

	public int getSeqid() {
		return seqid;
	}

	public void setSeqid(int seqid) {
		this.seqid = seqid;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public int getEtc1() {
		return etc1;
	}

	public void setEtc1(int etc1) {
		this.etc1 = etc1;
	}

	public int getEtc2() {
		return etc2;
	}

	public void setEtc2(int etc2) {
		this.etc2 = etc2;
	}

	@Override
	public String toString() {
		return "LogVO [seqid=" + seqid + ", tno=" + tno + ", orderno=" + orderno + ", status=" + status + ", pid=" + pid
				+ ", userid=" + userid + ", paymethod=" + paymethod + ", ordertime=" + ordertime + ", endtime="
				+ endtime + ", etc1=" + etc1 + ", etc2=" + etc2 + "]";
	}

}
