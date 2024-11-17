package com.webservicedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/book")
public class SachController {
	@GetMapping("/{maSach}")
	public String BookDetail(@PathVariable(value = "maSach") String maSach) {
		return "book/details";
	}
}
