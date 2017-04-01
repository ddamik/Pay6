package com.fintech.paysix.vo;

public class ProductVO {

	private int product_seq;
	private int product_store_fk;
	private String product_name;
	private int product_price;
	private int product_review_cnt;
	private int product_purchase_cnt;
	private int product_view_cnt;
	private String product_contents;
	private String product_etc1;
	private String product_etc2;

	public ProductVO() {
		super();
	}

	public ProductVO(int product_seq, int product_store_fk, String product_name, int product_price,
			int product_review_cnt, int product_purchase_cnt, int product_view_cnt, String product_contents,
			String product_etc1, String product_etc2) {
		super();
		this.product_seq = product_seq;
		this.product_store_fk = product_store_fk;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_review_cnt = product_review_cnt;
		this.product_purchase_cnt = product_purchase_cnt;
		this.product_view_cnt = product_view_cnt;
		this.product_contents = product_contents;
		this.product_etc1 = product_etc1;
		this.product_etc2 = product_etc2;
	}

	public int getProduct_seq() {
		return product_seq;
	}

	public void setProduct_seq(int product_seq) {
		this.product_seq = product_seq;
	}

	public int getProduct_store_fk() {
		return product_store_fk;
	}

	public void setProduct_store_fk(int product_store_fk) {
		this.product_store_fk = product_store_fk;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getProduct_review_cnt() {
		return product_review_cnt;
	}

	public void setProduct_review_cnt(int product_review_cnt) {
		this.product_review_cnt = product_review_cnt;
	}

	public int getProduct_purchase_cnt() {
		return product_purchase_cnt;
	}

	public void setProduct_purchase_cnt(int product_purchase_cnt) {
		this.product_purchase_cnt = product_purchase_cnt;
	}

	public int getProduct_view_cnt() {
		return product_view_cnt;
	}

	public void setProduct_view_cnt(int product_view_cnt) {
		this.product_view_cnt = product_view_cnt;
	}

	public String getProduct_contents() {
		return product_contents;
	}

	public void setProduct_contents(String product_contents) {
		this.product_contents = product_contents;
	}

	public String getProduct_etc1() {
		return product_etc1;
	}

	public void setProduct_etc1(String product_etc1) {
		this.product_etc1 = product_etc1;
	}

	public String getProduct_etc2() {
		return product_etc2;
	}

	public void setProduct_etc2(String product_etc2) {
		this.product_etc2 = product_etc2;
	}

	@Override
	public String toString() {
		return "ProductVO [product_seq=" + product_seq + ", product_store_fk=" + product_store_fk + ", product_name="
				+ product_name + ", product_price=" + product_price + ", product_review_cnt=" + product_review_cnt
				+ ", product_purchase_cnt=" + product_purchase_cnt + ", product_view_cnt=" + product_view_cnt
				+ ", product_contents=" + product_contents + ", product_etc1=" + product_etc1 + ", product_etc2="
				+ product_etc2 + "]";
	}

}
