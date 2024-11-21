package com.example.demo;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
public interface Sach1repository extends JpaRepository<Sach1, String>{

     //Tim kiem
	 List<Sach1> findByTenSachContainingIgnoreCase(String tenSach);
	 Page<Sach1> findBySoLuongConGreaterThan(int quantity, Pageable pageable);
	 Page<Sach1> findBySoLuongConLessThan(int quantity, Pageable pageable);

		/*
		 * // Filter
		 * 
		 * @Query("SELECT DISTINCT s.TenDoiTuong FROM Sach1 s") List<String>
		 * findDistinctTenDoiTuong();
		 * 
		 * List<Sach1> findByTenDoiTuongContainingIgnoreCase(String TenDoiTuong);
		 */
}
