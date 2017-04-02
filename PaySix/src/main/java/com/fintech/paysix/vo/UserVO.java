package com.fintech.paysix.vo;

public class UserVO {

	/**
	 * �����
	 *
	 * 	user_seq: column ��ȣ 
	 * 	user_name: ����� �̸� 
	 * 	user_email: ����� �̸��� 
	 * 	user_pwd: ����� ��й�ȣ 
	 * 	user_fb_token: ���̽��� ��ū 
	 * 	user_gmail_token: ���� ��ū 
	 * 	user_kakao_token: īī�� ��ū 
	 * 	user_st: ��������� ������������ ���� 1: �����, 2: ��������
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