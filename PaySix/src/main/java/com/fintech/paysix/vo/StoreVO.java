package com.fintech.paysix.vo;

public class StoreVO {

	private int store_seq;
	private String store_name;
	private String store_province;
	private String store_city;
	private String store_village;
	private String store_category;
	private int store_user_fk;
	private String store_tel;
	private String store_bank;
	private String store_account;
	private double store_latitude;
	private double store_longitude;
	private String store_etc1;
	private String store_etc2;

	public StoreVO() {
		super();
	}

	public StoreVO(int store_seq, String store_name, String store_province, String store_city, String store_village,
			String store_category, int store_user_fk, String store_tel, String store_bank, String store_account,
			double store_latitude, double store_longitude, String store_etc1, String store_etc2) {
		super();
		this.store_seq = store_seq;
		this.store_name = store_name;
		this.store_province = store_province;
		this.store_city = store_city;
		this.store_village = store_village;
		this.store_category = store_category;
		this.store_user_fk = store_user_fk;
		this.store_tel = store_tel;
		this.store_bank = store_bank;
		this.store_account = store_account;
		this.store_latitude = store_latitude;
		this.store_longitude = store_longitude;
		this.store_etc1 = store_etc1;
		this.store_etc2 = store_etc2;
	}

	public int getStore_seq() {
		return store_seq;
	}

	public void setStore_seq(int store_seq) {
		this.store_seq = store_seq;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_province() {
		return store_province;
	}

	public void setStore_province(String store_province) {
		this.store_province = store_province;
	}

	public String getStore_city() {
		return store_city;
	}

	public void setStore_city(String store_city) {
		this.store_city = store_city;
	}

	public String getStore_village() {
		return store_village;
	}

	public void setStore_village(String store_village) {
		this.store_village = store_village;
	}

	public String getStore_category() {
		return store_category;
	}

	public void setStore_category(String store_category) {
		this.store_category = store_category;
	}

	public int getStore_user_fk() {
		return store_user_fk;
	}

	public void setStore_user_fk(int store_user_fk) {
		this.store_user_fk = store_user_fk;
	}

	public String getStore_tel() {
		return store_tel;
	}

	public void setStore_tel(String store_tel) {
		this.store_tel = store_tel;
	}

	public String getStore_bank() {
		return store_bank;
	}

	public void setStore_bank(String store_bank) {
		this.store_bank = store_bank;
	}

	public String getStore_account() {
		return store_account;
	}

	public void setStore_account(String store_account) {
		this.store_account = store_account;
	}

	public double getStore_latitude() {
		return store_latitude;
	}

	public void setStore_latitude(double store_latitude) {
		this.store_latitude = store_latitude;
	}

	public double getStore_longitude() {
		return store_longitude;
	}

	public void setStore_longitude(double store_longitude) {
		this.store_longitude = store_longitude;
	}

	public String getStore_etc1() {
		return store_etc1;
	}

	public void setStore_etc1(String store_etc1) {
		this.store_etc1 = store_etc1;
	}

	public String getStore_etc2() {
		return store_etc2;
	}

	public void setStore_etc2(String store_etc2) {
		this.store_etc2 = store_etc2;
	}

	@Override
	public String toString() {
		return "StoreVO [store_seq=" + store_seq + ", store_name=" + store_name + ", store_province=" + store_province
				+ ", store_city=" + store_city + ", store_village=" + store_village + ", store_category="
				+ store_category + ", store_user_fk=" + store_user_fk + ", store_tel=" + store_tel + ", store_bank="
				+ store_bank + ", store_account=" + store_account + ", store_latitude=" + store_latitude
				+ ", store_longitude=" + store_longitude + ", store_etc1=" + store_etc1 + ", store_etc2=" + store_etc2
				+ "]";
	}

}