package com.webservicedemo.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webservicedemo.connect.Connect;
import com.webservicedemo.entity.Sach;
import com.webservicedemo.repository.SachRepository;

@Service
public class SachService {

    private final SachRepository sachRepository;

	static ArrayList<Sach> dsSach = new ArrayList<Sach>();
	
	public SachService(SachRepository sachRepository) {
        this.sachRepository = sachRepository;
    }
	
	public ArrayList<Sach> getAll() {
		try {
			Connection con = Connect.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM SACH";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maSach = rs.getString("MaSach");
				String tenSach = rs.getString("TenSach");
				String linkAnh = rs.getString("LinkAnh");
				String giaGoc = rs.getString("GiaGoc");
				String giaKM = rs.getString("GiaKM");
				String tenTacGia = rs.getString("TenTacGia");
				String tenDoiTuong = rs.getString("TenDoiTuong");
				String soTrang = rs.getString("SoTrang");
				int soLuongCon = rs.getInt("SoLuongCon");
				String maDM = rs.getString("MaDM");
				Sach book = new Sach(maSach, tenSach, linkAnh, giaGoc, giaKM, tenTacGia, tenDoiTuong, soTrang,
						soLuongCon, maDM);
				dsSach.add(book);
			}
			Connect.closeConnection(con);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return dsSach;
	}
	
	public Page<Sach> getBooksByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);  
        return sachRepository.findAll(pageable);        
    }
}
