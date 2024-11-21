package com.webservicedemo.entity;

public class Anh {

	private String maAnh;
	private String linkAnh;

	public Anh() {

	}

	public Anh(String maAnh, String linkAnh) {
		this.maAnh = maAnh;
		this.linkAnh = linkAnh;
	}

	public String getMaAnh() {
		return maAnh;
	}

	public void setMaAnh(String maAnh) {
		this.maAnh = maAnh;
	}

	public String getLinkAnh() {
		return linkAnh;
	}

	public void setLinkAnh(String linkAnh) {
		this.linkAnh = linkAnh;
	}

	@Override
	public String toString() {
		return maAnh + ";" + linkAnh;
	}

}
