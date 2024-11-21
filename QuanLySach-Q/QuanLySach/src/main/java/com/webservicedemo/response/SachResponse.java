package com.webservicedemo.response;

import java.util.ArrayList;
import java.util.Random;
import com.webservicedemo.entity.Sach;
import com.webservicedemo.service.SachService;

public class SachResponse extends Sach {
	private double doanhThu;
	private double loiNhuan;
	private double phanTramLN;

	private final SachService sachService;
	
	public SachResponse(SachService sachService) {
		this.sachService = sachService;
	}

	public SachResponse(String maSach, String tenSach, String giaGoc, String giaKM, double doanhThu, double loiNhuan,
			double phanTramLN) {
		this.sachService = null;
		this.setMaSach(maSach);
		this.setTenSach(tenSach);
		this.setGiaGoc(giaGoc);
		this.setGiaKM(giaKM);
		this.doanhThu = doanhThu;
		this.loiNhuan = loiNhuan;
		this.phanTramLN = phanTramLN;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	public double getLoiNhuan() {
		return loiNhuan;
	}

	public void setLoiNhuan(double loiNhuan) {
		this.loiNhuan = loiNhuan;
	}

	public double getPhanTramLN() {
		return phanTramLN;
	}

	public void setPhanTramLN(double phanTramLN) {
		this.phanTramLN = phanTramLN;
	}

	@Override
	public String toString() {
		return "SachResponse [doanhThu=" + doanhThu + ", loiNhuan=" + loiNhuan + ", phanTramLN=" + phanTramLN + "]";
	}

	public SachResponse thongKeDoanhThu(String maSach) {
		SachResponse book1 = new SachResponse(sachService);
		ArrayList<Sach> dsSach = sachService.getAll();
		for (Sach book2 : dsSach) {
			if (book2.getMaSach().equals(maSach) == true) {
				Random rand = new Random();
				int PTCP = rand.nextInt(21) + 20;
				String strGiaGoc1 = book2.getGiaGoc().substring(0, book2.getGiaGoc().length() - 1);
				String strGiaGoc2 = strGiaGoc1.replace(",", "");
				float giaGoc = Float.parseFloat(strGiaGoc2);
				String strGiaKM1 = book2.getGiaKM().substring(0, book2.getGiaKM().length() - 1);
				String strGiaKM2 = strGiaKM1.replace(",", "");
				double giaKM = Float.parseFloat(strGiaKM2);
				double von = ((giaGoc / 100) * PTCP) * (1000 - book2.getSoLuongCon());
				double doanhThu = giaKM * (1000 - book2.getSoLuongCon());
				double loiNhuan = doanhThu - von;
				double phanTramLN = (loiNhuan / doanhThu) * 100;
				book1.setMaSach(book2.getMaSach());
				book1.setTenSach(book2.getTenSach());
				book1.setGiaGoc(book2.getGiaGoc());
				book1.setGiaKM(book2.getGiaKM());
				book1.setDoanhThu(doanhThu);
				book1.setLoiNhuan(loiNhuan);
				book1.setPhanTramLN(phanTramLN);
			}
		}
		return book1;
	}
}
