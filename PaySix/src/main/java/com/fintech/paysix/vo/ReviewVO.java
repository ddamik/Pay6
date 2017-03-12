package com.fintech.paysix.vo;

import java.util.Date;

public class ReviewVO {

	private int seqid; // 일련번호
	private String pid; // 상품번호
	private String title; // 리뷰제목
	private String contents; // 리뷰내용
	private String editor; // 작성자
	private Date intime; // 작성일시
	private String expyn; // 컨텐츠노출여뷰

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
