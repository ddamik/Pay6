package com.fintech.paysix.vo;

import java.util.Date;

public class OrderVO {

	private int order_seq;
	private int order_no;
	private int order_status;
	private int order_product_fk;
	private int order_store_fk;
	private int order_user_fk;
	private Date order_savetime;
	private String order_etc1;
	private String order_etc2;

	public OrderVO() {
		super();
	}

	public OrderVO(int order_no, int order_status, int order_product_fk, int order_store_fk, int order_user_fk) {
		super();
		this.order_no = order_no;
		this.order_status = order_status;
		this.order_product_fk = order_product_fk;
		this.order_store_fk = order_store_fk;
		this.order_user_fk = order_user_fk;
	}

	public OrderVO(int order_seq, int order_no, int order_status, int order_product_fk, int order_store_fk,
			int order_user_fk, Date order_savetime) {
		super();
		this.order_seq = order_seq;
		this.order_no = order_no;
		this.order_status = order_status;
		this.order_product_fk = order_product_fk;
		this.order_store_fk = order_store_fk;
		this.order_user_fk = order_user_fk;
		this.order_savetime = order_savetime;
	}

	public int getOrder_seq() {
		return order_seq;
	}

	public void setOrder_seq(int order_seq) {
		this.order_seq = order_seq;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public int getOrder_product_fk() {
		return order_product_fk;
	}

	public void setOrder_product_fk(int order_product_fk) {
		this.order_product_fk = order_product_fk;
	}

	public int getOrder_store_fk() {
		return order_store_fk;
	}

	public void setOrder_store_fk(int order_store_fk) {
		this.order_store_fk = order_store_fk;
	}

	public int getOrder_user_fk() {
		return order_user_fk;
	}

	public void setOrder_user_fk(int order_user_fk) {
		this.order_user_fk = order_user_fk;
	}

	public Date getOrder_savetime() {
		return order_savetime;
	}

	public void setOrder_savetime(Date order_savetime) {
		this.order_savetime = order_savetime;
	}

	public String getOrder_etc1() {
		return order_etc1;
	}

	public void setOrder_etc1(String order_etc1) {
		this.order_etc1 = order_etc1;
	}

	public String getOrder_etc2() {
		return order_etc2;
	}

	public void setOrder_etc2(String order_etc2) {
		this.order_etc2 = order_etc2;
	}

}
