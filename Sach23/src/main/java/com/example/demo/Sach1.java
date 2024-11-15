package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "newsach")
public class Sach1 {
	@Id
	@Column(name="MaSach")
	private String MaSach;
	@Column(name="TenSach")
	private String tenSach;
	@Column(name="LinkAnh")
	private String LinkAnh;
	@Column(name="GiaGoc")
	private String GiaGoc;
	@Column(name="GiaKM")
	private String GiaKM;
	@Column(name="TenTacGia")
	private String TenTG;
	@Column(name="TenDoiTuong")
	private String TenDoiTuong;
	@Column(name="SoTrang")
	private String SoTrang;
	@Column(name="SoLuongCon")
	private String SoLuongCon;
	@Column(name="MaDM")
	private String MaDM;
	public Sach1(){}
	public Sach1(String MaSach, String tenSach, String LinkAnh,String GiaGoc, String GiaKM, String TenTG,
			String TenDoiTuong, String SoTrang, String SoLuongCon, String MaDM) {
		this.MaSach=MaSach;
		this.tenSach=tenSach;
		this.LinkAnh=LinkAnh;
		this.GiaGoc=GiaGoc;
		this.GiaKM=GiaKM;
		this.TenTG=TenTG;
		this.TenDoiTuong=TenDoiTuong;
		this.SoTrang=SoTrang;
		this.SoLuongCon=SoLuongCon;
		this.MaDM=MaDM;
	}
	public String getMaSach() {
		return MaSach;
	}
	public void setMaSach(String maSach) {
		MaSach = maSach;
	}
	
	
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getLinkAnh() {
		return LinkAnh;
	}
	public void setLinkAnh(String linkAnh) {
		LinkAnh = linkAnh;
	}
	public String getGiaGoc() {
		return GiaGoc;
	}
	public void setGiaGoc(String giaGoc) {
		GiaGoc = giaGoc;
	}
	public String getGiaKM() {
		return GiaKM;
	}
	public void setGiaKM(String giaKM) {
		GiaKM = giaKM;
	}
	public String getTenTG() {
		return TenTG;
	}
	public void setTenTG(String tenTG) {
		TenTG = tenTG;
	}
	public String getTenDoiTuong() {
		return TenDoiTuong;
	}
	public void setTenDoiTuong(String tenDoiTuong) {
		TenDoiTuong = tenDoiTuong;
	}
	public String getSoTrang() {
		return SoTrang;
	}
	public void setSoTrang(String soTrang) {
		SoTrang = soTrang;
	}
	public String getSoLuongCon() {
		return SoLuongCon;
	}
	public void setSoLuongCon(String soLuongCon) {
		SoLuongCon = soLuongCon;
	}
	public String getMaDM() {
		return MaDM;
	}
	public void setMaDM(String maDM) {
		MaDM = maDM;
	}
	
}