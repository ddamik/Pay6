package com.fintech.paysix.vo;

/**
 * @author Lee
 *
 */
public class ImgVO {

	private int img_seq;
	private String img_origin_name;
	private String img_origin_url;
	private String img_save_name;
	private String img_store_name;
	private int img_store_fk;
	private int img_product_fk;

	public ImgVO() {
		super();
	}

	public ImgVO(int img_seq, String img_origin_name, String img_origin_url, String img_save_name,
			String img_store_name, int img_store_fk, int img_product_fk) {
		super();
		this.img_seq = img_seq;
		this.img_origin_name = img_origin_name;
		this.img_origin_url = img_origin_url;
		this.img_save_name = img_save_name;
		this.img_store_name = img_store_name;
		this.img_store_fk = img_store_fk;
		this.img_product_fk = img_product_fk;
	}

	public int getImg_seq() {
		return img_seq;
	}

	public void setImg_seq(int img_seq) {
		this.img_seq = img_seq;
	}

	public String getImg_origin_name() {
		return img_origin_name;
	}

	public void setImg_origin_name(String img_origin_name) {
		this.img_origin_name = img_origin_name;
	}

	public String getImg_origin_url() {
		return img_origin_url;
	}

	public void setImg_origin_url(String img_origin_url) {
		this.img_origin_url = img_origin_url;
	}

	public String getImg_save_name() {
		return img_save_name;
	}

	public void setImg_save_name(String img_save_name) {
		this.img_save_name = img_save_name;
	}

	public String getImg_store_name() {
		return img_store_name;
	}

	public void setImg_store_name(String img_store_name) {
		this.img_store_name = img_store_name;
	}

	public int getImg_store_fk() {
		return img_store_fk;
	}

	public void setImg_store_fk(int img_store_fk) {
		this.img_store_fk = img_store_fk;
	}

	public int getImg_product_fk() {
		return img_product_fk;
	}

	public void setImg_product_fk(int img_product_fk) {
		this.img_product_fk = img_product_fk;
	}

	@Override
	public String toString() {
		return "ImgVO [img_seq=" + img_seq + ", img_origin_name=" + img_origin_name + ", img_origin_url="
				+ img_origin_url + ", img_save_name=" + img_save_name + ", img_store_name=" + img_store_name
				+ ", img_store_fk=" + img_store_fk + ", img_product_fk=" + img_product_fk + "]";
	}

}
