package com.webservicedemo.entity;

public class PhuongXa {

	private String maPhuong;
	private String tenPhuong;
	private String maQuan;

	public PhuongXa() {

	}

	public PhuongXa(String maPhuong, String tenPhuong, String maQuan) {
		this.maPhuong = maPhuong;
		this.tenPhuong = tenPhuong;
		this.maQuan = maQuan;
	}

	public String getMaPhuong() {
		return maPhuong;
	}

	public void setMaPhuong(String maPhuong) {
		this.maPhuong = maPhuong;
	}

	public String getTenPhuong() {
		return tenPhuong;
	}

	public void setTenPhuong(String tenPhuong) {
		this.tenPhuong = tenPhuong;
	}

	public String getMaQuan() {
		return maQuan;
	}

	public void setMaQuan(String maQuan) {
		this.maQuan = maQuan;
	}

	@Override
	public String toString() {
		return maPhuong + ";" + tenPhuong + ";" + maQuan;
	}

}
