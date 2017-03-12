package com.fintech.paysix.vo;

import java.util.Date;

public class OwnerOrderVO {

	private int seqid;
	private int orderno;
	private int tno;
	private String status;
	private Date ordertime;
	private String pname;

	public OwnerOrderVO() {
		super();
	}

	public OwnerOrderVO(int seqid, int orderno, int tno, String status, String pname) {
		super();
		this.seqid = seqid;
		this.orderno = orderno;
		this.tno = tno;
		this.status = status;
		this.pname = pname;
	}

	public OwnerOrderVO(int seqid, int orderno, int tno, String status, Date ordertime, String pname) {
		super();
		this.seqid = seqid;
		this.orderno = orderno;
		this.tno = tno;
		this.status = status;
		this.ordertime = ordertime;
		this.pname = pname;
	}

	public int getSeqid() {
		return seqid;
	}

	public void setSeqid(int seqid) {
		this.seqid = seqid;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	@Override
	public String toString() {
		return "OwnerOrderVO [seqid=" + seqid + ", orderno=" + orderno + ", tno=" + tno + ", status=" + status
				+ ", ordertime=" + ordertime + ", pname=" + pname + "]";
	}

}
