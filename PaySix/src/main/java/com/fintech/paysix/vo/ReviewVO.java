package com.fintech.paysix.vo;

import java.util.Date;

public class ReviewVO {

	private int review_seq;
	private int review_product_fk;
	private int review_user_fk;
	private Date review_savetime;
	private String review_contents;

	public ReviewVO() {
		super();
	}

	public ReviewVO(int review_seq, int review_product_fk, int review_user_fk, Date review_savetime,
			String review_contents) {
		super();
		this.review_seq = review_seq;
		this.review_product_fk = review_product_fk;
		this.review_user_fk = review_user_fk;
		this.review_savetime = review_savetime;
		this.review_contents = review_contents;
	}

	public int getReview_seq() {
		return review_seq;
	}

	public void setReview_seq(int review_seq) {
		this.review_seq = review_seq;
	}

	public int getReview_product_fk() {
		return review_product_fk;
	}

	public void setReview_product_fk(int review_product_fk) {
		this.review_product_fk = review_product_fk;
	}

	public int getReview_user_fk() {
		return review_user_fk;
	}

	public void setReview_user_fk(int review_user_fk) {
		this.review_user_fk = review_user_fk;
	}

	public Date getReview_savetime() {
		return review_savetime;
	}

	public void setReview_savetime(Date review_savetime) {
		this.review_savetime = review_savetime;
	}

	public String getReview_contents() {
		return review_contents;
	}

	public void setReview_contents(String review_contents) {
		this.review_contents = review_contents;
	}

	@Override
	public String toString() {
		return "ReviewVO [review_seq=" + review_seq + ", review_product_fk=" + review_product_fk + ", review_user_fk="
				+ review_user_fk + ", review_savetime=" + review_savetime + ", review_contents=" + review_contents
				+ "]";
	}

}
