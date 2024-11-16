package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "SACH")
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
	private int soLuongCon;
	@Column(name="MaDM")
	private String MaDM;
	public Sach1(){}
	
	public Sach1(String maSach, String tenSach, String linkAnh, String giaGoc, String giaKM, String tenTG,
			String tenDoiTuong, String soTrang, int soLuongCon, String maDM) {
		MaSach = maSach;
		this.tenSach = tenSach;
		LinkAnh = linkAnh;
		GiaGoc = giaGoc;
		GiaKM = giaKM;
		TenTG = tenTG;
		TenDoiTuong = tenDoiTuong;
		SoTrang = soTrang;
		this.soLuongCon = soLuongCon;
		MaDM = maDM;
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

	public int getSoLuongCon() {
		return this.soLuongCon;
	}

	public void setSoLuongCon(int soLuongCon) {
		this.soLuongCon = soLuongCon;
	}

	public String getMaDM() {
		return MaDM;
	}
	public void setMaDM(String maDM) {
		MaDM = maDM;
	}
	public int getSoLuongBan() {
		return (1000 - this.soLuongCon);
	}
	public String getGiamGia() {
		String sales = "";
		if(this.soLuongCon>700 & this.soLuongCon<800) {
			sales="10%";
		}
		else if(this.soLuongCon<900) {
			sales="20%";
		}
		else if(this.soLuongCon<=1000) {
			sales="30%";
		}
		return sales;
	}
	public float getGiaSales() {
		float salesCost = 0;
		String price = GiaKM.substring(0, GiaKM.length()-1).replace(",", "");
        float price2 = Float.parseFloat(price);
		if(this.soLuongCon>700 & this.soLuongCon<800) {
			salesCost = price2 * 90 / 100;
		}
		else if(this.soLuongCon<900) {
			salesCost = price2 * 80 / 100;
		}
		else if(this.soLuongCon<=1000) {
			salesCost = price2 * 70 / 100;
		}
		return salesCost;
	}
}