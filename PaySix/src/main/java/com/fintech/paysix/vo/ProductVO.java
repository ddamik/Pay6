package com.fintech.paysix.vo;

public class ProductVO {

	private String pid; // 상품번호 string 형태의 int / 1001 + 0001 / 앞에 숫자 4개는 store
						// id + 뒤에 숫자 4개는 메뉴 id
	private String pName; // 상품명
	private int price; // 상품가격
	private String pImgUrl; // 상품이미지
	private int rCount; // 리뷰수 default: 0
	private int vCount; // 조회수 default: 0
	private int pCount; // 구매수 default: 0
	private String sId; // 매장번호

	// insert into productinfo(pid, pName, price, pimgurl, sid)
	// values("10010001", "제육볶음", 6000,
	// "C:\Users\Lee\Desktop\Fintech\img\10010001.jpg");

	public ProductVO() {
		super();
	}

	public ProductVO(String pid, String pName, int price, String pImgUrl, int rCount, int vCount, int pCount,
			String sId) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.price = price;
		this.pImgUrl = pImgUrl;
		this.rCount = rCount;
		this.vCount = vCount;
		this.pCount = pCount;
		this.sId = sId;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	@Override
	public String toString() {
		return "ProductVO [pid=" + pid + ", pName=" + pName + ", price=" + price + ", pImgUrl=" + pImgUrl + ", rCount="
				+ rCount + ", vCount=" + vCount + ", pCount=" + pCount + ", sId=" + sId + "]";
	}

}
