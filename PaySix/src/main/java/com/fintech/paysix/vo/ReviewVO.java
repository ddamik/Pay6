package com.fintech.paysix.vo;

import java.util.Date;

public class ReviewVO {

	private int seqid; // �Ϸù�ȣ
	private String pid; // ��ǰ��ȣ
	private String title; // ��������
	private String contents; // ���䳻��
	private String editor; // �ۼ���
	private Date intime; // �ۼ��Ͻ�
	private String expyn; // ���������⿩��

	public ReviewVO() {
		super();
	}

	public ReviewVO(String pid, String title, String contents, String editor) {
		super();
		this.pid = pid;
		this.title = title;
		this.contents = contents;
		this.editor = editor;
	}

	public ReviewVO(int seqid, String pid, String title, String contents, String editor, Date intime, String expyn) {
		super();
		this.seqid = seqid;
		this.pid = pid;
		this.title = title;
		this.contents = contents;
		this.editor = editor;
		this.intime = intime;
		this.expyn = expyn;
	}

	public int getSeqid() {
		return seqid;
	}

	public void setSeqid(int seqid) {
		this.seqid = seqid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public String getExpyn() {
		return expyn;
	}

	public void setExpyn(String expyn) {
		this.expyn = expyn;
	}

	@Override
	public String toString() {
		return "ReviewVO [seqid=" + seqid + ", pid=" + pid + ", title=" + title + ", contents=" + contents + ", editor="
				+ editor + ", intime=" + intime + ", expyn=" + expyn + "]";
	}

}
