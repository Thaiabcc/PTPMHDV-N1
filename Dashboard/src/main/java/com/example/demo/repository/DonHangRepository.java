package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DonHang;

public interface DonHangRepository extends JpaRepository<DonHang, Integer> {

}
