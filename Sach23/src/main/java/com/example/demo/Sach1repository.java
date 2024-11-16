package com.example.demo;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Sach1repository extends JpaRepository<Sach1, String> {

	 List<Sach1> findByTenSachContainingIgnoreCase(String tenSach);
	 Page<Sach1> findBySoLuongConGreaterThan(int quantity, Pageable pageable);
	 Page<Sach1> findBySoLuongConLessThan(int quantity, Pageable pageable);
}
