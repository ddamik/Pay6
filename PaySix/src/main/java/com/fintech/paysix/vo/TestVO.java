package com.fintech.paysix.vo;

public class TestVO {

	private int _idx;
	private int iValue;

	public TestVO() {
		super();
	}

	public TestVO(int _idx, int iValue) {
		super();
		this._idx = _idx;
		this.iValue = iValue;
	}

	public int get_idx() {
		return _idx;
	}

	public void set_idx(int _idx) {
		this._idx = _idx;
	}

	public int getiValue() {
		return iValue;
	}

	public void setiValue(int iValue) {
		this.iValue = iValue;
	}

	@Override
	public String toString() {
		return "TestVO [_idx=" + _idx + ", iValue=" + iValue + "]";
	}

	
}
