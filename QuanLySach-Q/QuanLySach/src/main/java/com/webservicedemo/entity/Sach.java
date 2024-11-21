package com.webservicedemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SACH")
public class Sach {

	@Id
	@Column(name = "MaSach")
	private String maSach;
	@Column(name = "TenSach")
	private String tenSach;
	@Column(name = "LinkAnh")
	private String linkAnh;
	@Column(name = "GiaGoc")
	private String giaGoc;
	@Column(name = "GiaKM")
	private String giaKM;
	@Column(name = "TenTacGia")
	private String tacGia;
	@Column(name = "TenDoiTuong")
	private String doiTuong;
	@Column(name = "SoTrang")
	private String soTrang;
	@Column(name = "SoLuongCon")
	private int soLuongCon;
	@Column(name = "MaDM")
	private String maDM;

	public Sach() {

	}

	public Sach(String maSach) {
		this.maSach = maSach;
	}

	public Sach(String maSach, String tenSach, String linkAnh, String giaGoc, String giaKM, String tacGia,
			String doiTuong, String soTrang, int soLuongCon, String maDM) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.linkAnh = linkAnh;
		this.giaGoc = giaGoc;
		this.giaKM = giaKM;
		this.tacGia = tacGia;
		this.doiTuong = doiTuong;
		this.soTrang = soTrang;
		this.soLuongCon = soLuongCon;
		this.maDM = maDM;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getLinkAnh() {
		return linkAnh;
	}

	public void setLinkAnh(String linkAnh) {
		this.linkAnh = linkAnh;
	}

	public String getGiaGoc() {
		return giaGoc;
	}

	public void setGiaGoc(String giaGoc) {
		this.giaGoc = giaGoc;
	}

	public String getGiaKM() {
		return giaKM;
	}

	public void setGiaKM(String giaKM) {
		this.giaKM = giaKM;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getDoiTuong() {
		return doiTuong;
	}

	public void setDoiTuong(String doiTuong) {
		this.doiTuong = doiTuong;
	}

	public String getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(String soTrang) {
		this.soTrang = soTrang;
	}

	public int getSoLuongCon() {
		return soLuongCon;
	}

	public void setSoLuongCon(int soLuongCon) {
		this.soLuongCon = soLuongCon;
	}

	public String getMaDM() {
		return maDM;
	}

	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}

//	@Override
//	public String toString() {
//		return maSach + "\t" + tenSach + "\t" + linkAnh + "\t" + giaGoc + "\t" + giaKM + "\t" + tacGia + "\t" + doiTuong
//				+ "\t" + soTrang + "\t" + soLuongCon + "\t" + maDM;
//	}
}
