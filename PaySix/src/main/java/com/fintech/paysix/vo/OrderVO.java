package com.fintech.paysix.vo;

import java.util.Date;

public class OrderVO {

	private int order_seq;
	private int order_no;
	private int order_store_fk;
	private int order_product_fk;
	private int order_product_price;
	private int order_user_fk;
	private Date order_savetime;
	private String etc1;
	private String etc2;

	public OrderVO() {
		super();
	}

	public OrderVO(int order_seq, int order_no, int order_store_fk, int order_product_fk, int order_product_price,
			int order_user_fk, Date order_savetime, String etc1, String etc2) {
		super();
		this.order_seq = order_seq;
		this.order_no = order_no;
		this.order_store_fk = order_store_fk;
		this.order_product_fk = order_product_fk;
		this.order_product_price = order_product_price;
		this.order_user_fk = order_user_fk;
		this.order_savetime = order_savetime;
		this.etc1 = etc1;
		this.etc2 = etc2;
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

	public int getOrder_store_fk() {
		return order_store_fk;
	}

	public void setOrder_store_fk(int order_store_fk) {
		this.order_store_fk = order_store_fk;
	}

	public int getOrder_product_fk() {
		return order_product_fk;
	}

	public void setOrder_product_fk(int order_product_fk) {
		this.order_product_fk = order_product_fk;
	}

	public int getOrder_product_price() {
		return order_product_price;
	}

	public void setOrder_product_price(int order_product_price) {
		this.order_product_price = order_product_price;
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

	public String getEtc1() {
		return etc1;
	}

	public void setEtc1(String etc1) {
		this.etc1 = etc1;
	}

	public String getEtc2() {
		return etc2;
	}

	public void setEtc2(String etc2) {
		this.etc2 = etc2;
	}

	@Override
	public String toString() {
		return "OrderVO [order_seq=" + order_seq + ", order_no=" + order_no + ", order_store_fk=" + order_store_fk
				+ ", order_product_fk=" + order_product_fk + ", order_product_price=" + order_product_price
				+ ", order_user_fk=" + order_user_fk + ", order_savetime=" + order_savetime + ", etc1=" + etc1
				+ ", etc2=" + etc2 + "]";
	}

}
