package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="SachEntity")
@Table(name ="newsach")
public class Sach {

	@Id
	@Column(name = "MaSach", columnDefinition = "varchar(25)")
	private String MaSach;
	@Column(name = "TenSach", columnDefinition = "nvarchar(200)")
	private String tenSach;
	@Column(name = "LinkAnh", columnDefinition = "varchar(MAX)")
	private String LinkAnh;
	@Column(name = "GiaGoc", columnDefinition = "varchar(30)")
	private String GiaGoc;
	@Column(name = "GiaKM", columnDefinition = "varchar(30)")
	private String GiaKM;
	@Column(name = "TenTacGia", columnDefinition = "nvarchar(150)")
	private String TenTG;
	@Column(name = "TenDoiTuong", columnDefinition = "nvarchar(150)")
	private String TenDoiTuong;
	@Column(name = "SoTrang", columnDefinition = "varchar(10)")
	private String SoTrang;
	@Column(name = "SoLuongCon")
	private int soLuongCon;
	@Column(name = "MaDM", columnDefinition = "varchar(25)")
	private String MaDM;

	public Sach() {
	}

	public Sach(String maSach, String tenSach, String linkAnh, String giaGoc, String giaKM, String tenTG,
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
		if (this.soLuongCon > 700 & this.soLuongCon < 800) {
			sales = "10%";
		} else if (this.soLuongCon < 900 & this.soLuongCon >= 800) {
			sales = "20%";
		} else if (this.soLuongCon <= 1000 & this.soLuongCon >= 900) {
			sales = "30%";
		} else
			sales = "0%";
		return sales;
	}

	public float getGiaSales() {
		float salesCost = 0;
		String price = GiaKM.substring(0, GiaKM.length() - 1).replace(",", "");
		float price2 = Float.parseFloat(price);
		if (this.soLuongCon > 700 & this.soLuongCon < 800) {
			salesCost = price2 * 90 / 100;
		} else if (this.soLuongCon < 900 & this.soLuongCon >= 800) {
			salesCost = price2 * 80 / 100;
		} else if (this.soLuongCon <= 1000 & this.soLuongCon >= 900) {
			salesCost = price2 * 70 / 100;
		} else
			salesCost = price2;
		return salesCost;
	}
}