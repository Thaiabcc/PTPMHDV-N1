package com.example.demo;


import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
public interface Sach1repository extends JpaRepository<Sach1, String> {

	 List<Sach1> findByTenSachContainingIgnoreCase(String tenSach);

}
