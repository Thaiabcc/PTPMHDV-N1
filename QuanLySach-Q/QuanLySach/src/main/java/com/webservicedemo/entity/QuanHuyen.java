package com.webservicedemo.entity;

public class QuanHuyen {

	private String maQuan;
	private String tenQuan;
	private String maTinhTP;
	
	public QuanHuyen() {
	
	}

	public QuanHuyen(String maQuan, String tenQuan, String maTinhTP) {
		this.maQuan = maQuan;
		this.tenQuan = tenQuan;
		this.maTinhTP = maTinhTP;
	}

	public String getMaQuan() {
		return maQuan;
	}

	public void setMaQuan(String maQuan) {
		this.maQuan = maQuan;
	}

	public String getTenQuan() {
		return tenQuan;
	}

	public void setTenQuan(String tenQuan) {
		this.tenQuan = tenQuan;
	}

	public String getMaTinhTP() {
		return maTinhTP;
	}

	public void setMaTinhTP(String maTinhTP) {
		this.maTinhTP = maTinhTP;
	}

	@Override
	public String toString() {
		return maQuan + ";" + tenQuan + ";" + maTinhTP;
	}
	
}
