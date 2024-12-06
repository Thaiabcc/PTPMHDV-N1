package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Sach;

public interface SachRepository extends JpaRepository<Sach, String> {

	List<Sach> findByTenSachContainingIgnoreCase(String tenSach);

	Page<Sach> findBySoLuongConGreaterThan(int quantity, Pageable pageable);

	Page<Sach> findBySoLuongConLessThan(int quantity, Pageable pageable);

	static List<Sach> findByTenDoiTuong(String tenDoiTuong) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}
