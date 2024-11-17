package com.webservicedemo.entity;

public class TinhTP {

	private String maTinhTP;
	private String tenTinhTP;

	public TinhTP() {

	}

	public TinhTP(String maTinhTP, String tenTinhTP) {
		this.maTinhTP = maTinhTP;
		this.tenTinhTP = tenTinhTP;
	}

	public String getMaTinhTP() {
		return maTinhTP;
	}

	public void setMaTinhTP(String maTinhTP) {
		this.maTinhTP = maTinhTP;
	}

	public String getTenTinhTP() {
		return tenTinhTP;
	}

	public void setTenTinhTP(String tenTinhTP) {
		this.tenTinhTP = tenTinhTP;
	}

	@Override
	public String toString() {
		return maTinhTP + ";" + tenTinhTP;
	}

}
