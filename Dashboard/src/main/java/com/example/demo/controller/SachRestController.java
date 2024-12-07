package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sach;
import com.example.demo.response.PagedResponse;
import com.example.demo.response.SachResponse;
import com.example.demo.service.SachService;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class SachRestController {

	private SachService sachService;

	public SachRestController(SachService sachservice) {
		this.sachService = sachservice;
	}

	@GetMapping("/bestsellers")
	public ResponseEntity<PagedResponse<Sach>> getProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int size) {
		Page<Sach> sach = sachService.getSachBanChays(page, size);
		return ResponseEntity.ok(new PagedResponse<>(sach));
	}

	@GetMapping("/high-stock")
	public ResponseEntity<PagedResponse<Sach>> getHighStocks(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int size) {
		Page<Sach> sach = sachService.getSachTonKhos(page, size);
		return ResponseEntity.ok(new PagedResponse<>(sach));
	}

	@GetMapping("/profit/{maSach}")
	public SachResponse thongKeLoiNhuanSach(@PathVariable(name = "maSach") String maSach) {
		return sachService.profitOfBook(maSach);
	}
}