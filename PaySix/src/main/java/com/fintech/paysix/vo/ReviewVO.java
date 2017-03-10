package com.fintech.paysix.vo;

import java.util.Date;

public class ReviewVO {

	private int seqId;				//	�Ϸù�ȣ
	private String pId;				//	��ǰ��ȣ
	private String title;			//	��������
	private String contents;		//	���䳻��
	private String editor;			//	�ۼ���
	private Date inTime;			//	�ۼ��Ͻ�
	private String expyn;			//	���������⿩��

	public ReviewVO() {
		super();
	}

	public ReviewVO(int seqId, String pId, String title, String contents, String editor, Date inTime, String expyn) {
		super();
		this.seqId = seqId;
		this.pId = pId;
		this.title = title;
		this.contents = contents;
		this.editor = editor;
		this.inTime = inTime;
		this.expyn = expyn;
	}

	public int getSeqId() {
		return seqId;
	}

	public void setSeqId(int seqId) {
		this.seqId = seqId;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
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

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public String getExpyn() {
		return expyn;
	}

	public void setExpyn(String expyn) {
		this.expyn = expyn;
	}

	@Override
	public String toString() {
		return "ReviewVO [seqId=" + seqId + ", pId=" + pId + ", title=" + title + ", contents=" + contents + ", editor="
				+ editor + ", inTime=" + inTime + ", expyn=" + expyn + "]";
	}

}
