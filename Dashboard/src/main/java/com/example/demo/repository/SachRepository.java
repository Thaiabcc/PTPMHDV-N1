package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Sach;

public interface SachRepository extends JpaRepository<Sach, String> {

	List<Sach> findByMaDM(String MaDM);
	
	Sach findByMaSach(String MaSach); 
	
	List<Sach> findByTenSachContainingIgnoreCase(String TenSach);

	Page<Sach> findBySoLuongConGreaterThan(int quantity, Pageable pageable);

	Page<Sach> findBySoLuongConLessThan(int quantity, Pageable pageable);
}
