package com.webservicedemo.controller;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.webservicedemo.entity.Sach;
import com.webservicedemo.response.SachResponse;
import com.webservicedemo.service.SachService;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ApiController {

	private final SachService sachService;

	@Autowired
	ApiController(SachService sachService) {
		this.sachService = sachService;
	}

	@GetMapping("/allBook")
	public Page<Sach> getBook(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
		return sachService.getBooksByPage(page, size);
	}

//Offset = page - 1 * size
//	@GetMapping("/bookProfit/{maSach}")
//	public SachResponse thongKeLoiNhuanSach(@PathVariable(name = "maSach") String maSach) {
//		SachResponse bookRes = new SachResponse();
//		ArrayList<Sach> dsSach = new ArrayList<Sach>();
//		dsSach = (ArrayList<Sach>) sachService.getBooksToList();
//		for (Sach book : dsSach) {
//			if (book.getMaSach().equals(maSach) == true) {
//				Random rand = new Random();
//				int PTCP = rand.nextInt(21) + 20;
//				String strGiaGoc1 = book.getGiaGoc().substring(0, book.getGiaGoc().length() - 1);
//				String strGiaGoc2 = strGiaGoc1.replace(",", "");
//				float giaGoc = Float.parseFloat(strGiaGoc2);
//				String strGiaKM1 = book.getGiaKM().substring(0, book.getGiaKM().length() - 1);
//				String strGiaKM2 = strGiaKM1.replace(",", "");
//				double giaKM = Float.parseFloat(strGiaKM2);
//				double von = ((giaGoc / 100) * PTCP) * (1000 - book.getSoLuongCon());
//				double doanhThu = giaKM * (1000 - book.getSoLuongCon());
//				double loiNhuan = doanhThu - von;
//				double phanTramLN = (loiNhuan / doanhThu) * 100;
//				bookRes.setMaSach(book.getMaSach());
//				bookRes.setTenSach(book.getTenSach());
//				bookRes.setGiaGoc(book.getGiaGoc());
//				bookRes.setGiaKM(book.getGiaKM());
//				bookRes.setDoanhThu(doanhThu);
//				bookRes.setLoiNhuan(loiNhuan);
//				bookRes.setPhanTramLN(phanTramLN);
//				return bookRes;
//			}
//		}
//		return bookRes;
//	}
//	
	@GetMapping("/bookProfit/{maSach}")
	public SachResponse thongKeLoiNhuanSach(@PathVariable(name = "maSach") String maSach) {
		SachResponse book = new SachResponse(sachService);
		return book.thongKeDoanhThu(maSach);
	}
}
