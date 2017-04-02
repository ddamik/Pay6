package com.fintech.paysix.vo;

public class UserVO {

	/**
	 * 사용자
	 *
	 * 	user_seq: column 번호 
	 * 	user_name: 사용자 이름 
	 * 	user_email: 사용자 이메일 
	 * 	user_pwd: 사용자 비밀번호 
	 * 	user_fb_token: 페이스북 토큰 
	 * 	user_gmail_token: 구글 토큰 
	 * 	user_kakao_token: 카카오 토큰 
	 * 	user_st: 사용자인지 상점주인인지 구분 1: 사용자, 2: 상점주인
	 */

	private int user_seq;
	private String user_name;
	private String user_email;
	private String user_pwd;
	private String user_fb_token;
	private String user_gmail_token;
	private String user_kakao_token;
	private int user_st;

	public UserVO() {
		super();
	}

	public UserVO(int user_seq, String user_name, String user_email, String user_pwd, String user_fb_token,
			String user_gmail_token, String user_kakao_token, int user_st) {
		super();
		this.user_seq = user_seq;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_pwd = user_pwd;
		this.user_fb_token = user_fb_token;
		this.user_gmail_token = user_gmail_token;
		this.user_kakao_token = user_kakao_token;
		this.user_st = user_st;
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_fb_token() {
		return user_fb_token;
	}

	public void setUser_fb_token(String user_fb_token) {
		this.user_fb_token = user_fb_token;
	}

	public String getUser_gmail_token() {
		return user_gmail_token;
	}

	public void setUser_gmail_token(String user_gmail_token) {
		this.user_gmail_token = user_gmail_token;
	}

	public String getUser_kakao_token() {
		return user_kakao_token;
	}

	public void setUser_kakao_token(String user_kakao_token) {
		this.user_kakao_token = user_kakao_token;
	}

	public int getUser_st() {
		return user_st;
	}

	public void setUser_st(int user_st) {
		this.user_st = user_st;
	}

	@Override
	public String toString() {
		return "UserVO [user_seq=" + user_seq + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_pwd=" + user_pwd + ", user_fb_token=" + user_fb_token + ", user_gmail_token="
				+ user_gmail_token + ", user_kakao_token=" + user_kakao_token + ", user_st=" + user_st + "]";
	}

}