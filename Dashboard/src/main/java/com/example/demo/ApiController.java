package com.example.demo;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ApiController {
	private Sach1service sachservice;

	public ApiController(Sach1service sachservice) {
		this.sachservice = sachservice;
	}

	@GetMapping("/bestsellers")
    public ResponseEntity<PagedRespone1<Sach1>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Page<Sach1> sach = sachservice.getSachBanChays(page, size);
        return ResponseEntity.ok(new PagedRespone1<>(sach));
    }
	@GetMapping("/high-stock")
    public ResponseEntity<PagedRespone1<Sach1>> getHighStocks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Page<Sach1> sach = sachservice.getSachTonKhos(page, size);
        return ResponseEntity.ok(new PagedRespone1<>(sach));
    }	
}