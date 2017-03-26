package com.fintech.paysix.vo;

public class ProductVO {

	private String pid; // ��ǰ��ȣ string ������ int / 1001 + 0001 / �տ� ���� 4���� store
						// id + �ڿ� ���� 4���� �޴� id
	private String pName; // ��ǰ��
	private int pprice; // ��ǰ����
	private String pImgUrl; // ��ǰ�̹���
	private int rCount; // ����� default: 0
	private int vCount; // ��ȸ�� default: 0
	private int pCount; // ���ż� default: 0
	private String sId; // �����ȣ
	private int hackaton;

	// insert into productinfo(pid, pName, price, pimgurl, sid)
	// values("10010001", "��������", 6000,
	// "C:\Users\Lee\Desktop\Fintech\img\10010001.jpg");

	public ProductVO() {
		super();
	}

	public ProductVO(String pid, String pName, int pprice, String pImgUrl, int rCount, int vCount, int pCount,
			String sId) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.pprice = pprice;
		this.pImgUrl = pImgUrl;
		this.rCount = rCount;
		this.vCount = vCount;
		this.pCount = pCount;
		this.sId = sId;
	}

	public ProductVO(String pid, String pName, int pprice, String pImgUrl, int rCount, int vCount, int pCount,
			String sId, int hackaton) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.pprice = pprice;
		this.pImgUrl = pImgUrl;
		this.rCount = rCount;
		this.vCount = vCount;
		this.pCount = pCount;
		this.sId = sId;
		this.hackaton = hackaton;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getpImgUrl() {
		return pImgUrl;
	}

	public void setpImgUrl(String pImgUrl) {
		this.pImgUrl = pImgUrl;
	}

	public int getrCount() {
		return rCount;
	}

	public void setrCount(int rCount) {
		this.rCount = rCount;
	}

	public int getvCount() {
		return vCount;
	}

	public void setvCount(int vCount) {
		this.vCount = vCount;
	}

	public int getpCount() {
		return pCount;
	}

	public void setpCount(int pCount) {
		this.pCount = pCount;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public int getHackaton() {
		return hackaton;
	}

	public void setHackaton(int hackaton) {
		this.hackaton = hackaton;
	}

	@Override
	public String toString() {
		return "ProductVO [pid=" + pid + ", pName=" + pName + ", pprice=" + pprice + ", pImgUrl=" + pImgUrl
				+ ", rCount=" + rCount + ", vCount=" + vCount + ", pCount=" + pCount + ", sId=" + sId + ", hackaton="
				+ hackaton + "]";
	}

}
