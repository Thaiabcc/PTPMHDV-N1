package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.demo.model.Sach;
import com.example.demo.model.Sach1DTO;
import com.example.demo.service.SachService;
import com.example.demo.Response.PagedResponse;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class Sach1controller {

	@Autowired
	private SachService sach1service;

	@GetMapping("/home")
	public String showDashboard() {
		return "books/home";
	}

	@GetMapping("/search")
	public String search(@RequestParam String tenSach, Model model) {
		List<Sach> books = sach1service.searchByTenSach(tenSach);
		model.addAttribute("books", books);
		return "books/search";
	}

	@GetMapping({ "", "/books" })
	public String showsach(Model model, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size) {
		// Lấy trang sách từ service
		Page<Sach> booksPage = sach1service.getBooksByPage(page, size);

		// Thêm dữ liệu vào model để hiển thị trong view
		model.addAttribute("books", booksPage.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", booksPage.getTotalPages());
		model.addAttribute("size", size); // Thêm kích thước trang vào model

		return "books/index3";
	}

	@GetMapping("/create")
	public String showCreatePage(Model model) {
		model.addAttribute("sach1dto", new Sach1DTO());
		return "books/createbook";
	}

	// Them Sach
	@PostMapping("/create")
	public String createBook(@Valid @ModelAttribute("sach1dto") Sach1DTO sach1dto, BindingResult result) {

		if (result.hasErrors()) {
			return "books/createbook";
		}
		sach1service.saveBook(sach1dto);

		return "redirect:/books";
	}
	/*
	 * @GetMapping("/search") public String searchBooks(@RequestParam("keyword")
	 * String keyword, Model model) { List<Sach1> searchResults =
	 * sach1service.searchBooksByName(keyword); // Service gọi hàm tìm kiếm
	 * model.addAttribute("books", searchResults); model.addAttribute("keyword",
	 * keyword); return "books/search-results"; // Giao diện hiển thị kết quả }
	 */

	@GetMapping("/edit")
	public String showEditPage(Model model, @RequestParam String MaSach) {
		return sach1service.findById(MaSach).map(sach -> {
			Sach1DTO sach1dto = convertToDTO(sach);
			model.addAttribute("sach1dto", sach1dto);
			return "books/edit";
		}).orElse("redirect:/books");
	}

	private Sach1DTO convertToDTO(Sach sach) {
		Sach1DTO sach1dto = new Sach1DTO();
		sach1dto.setMaSach(sach.getMaSach());
		sach1dto.setTenSach(sach.getTenSach());
		sach1dto.setGiaGoc(sach.getGiaGoc());
		sach1dto.setGiaKM(sach.getGiaKM());
		sach1dto.setTenTG(sach.getTenTG());
		sach1dto.setTenDoiTuong(sach.getTenDoiTuong());
		sach1dto.setSoTrang(sach.getSoTrang());
		sach1dto.setSoLuongCon(sach.getSoLuongCon());
		sach1dto.setLinkAnh(sach.getLinkAnh());
		sach1dto.setMaDM(sach.getMaDM());
		return sach1dto;
	}

	@PostMapping("/edit")
	public String editBook(@Valid @ModelAttribute("sach1dto") Sach1DTO sach1dto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "books/edit";
		}
		sach1service.updateBook(sach1dto);
		return "redirect:/books";
	}

	@GetMapping("/delete")
	public String deleteBook(@RequestParam String MaSach) {
		sach1service.deleteBook(MaSach);
		return "redirect:/books";
	}

	@GetMapping("/books/home")
	public String showTopSellingBooks(@RequestParam(defaultValue = "10") int limit, Model model) {
		List<Sach> topSellingBooks = sach1service.getTopSellingBooks(limit);
		model.addAttribute("topSellingBooks", topSellingBooks);
		System.out.println("Top selling books in model: " + topSellingBooks); // In ra model
		return "books/home"; // Tên tệp HTML
	}

	@GetMapping("high-stock")
	public String showBookTonKho(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "30") int size, Model model) {
		// Lấy danh sách sách tồn kho > 700 với phân trang
		Page<Sach> booksPage = sach1service.getBooksWithSoLuongConGreaterThan700(page, 30);

		// Thêm dữ liệu vào model để hiển thị trong view
		model.addAttribute("books", booksPage.getContent()); // Danh sách sách trong trang hiện tại
		model.addAttribute("currentPage", page); // Trang hiện tại
		model.addAttribute("totalPages", booksPage.getTotalPages()); // Tổng số trang

		return "books/high-stock";
	}

	@GetMapping("thongke")
	public String showThongKe() {
		return "books/thongke";
	}

	@GetMapping("best-seller")
	public String showBookBest(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "25") int size, Model model) {
		// Lấy danh sách sách tồn kho < 300 với phân trang
		Page<Sach> booksPage = sach1service.getBooksWithSoLuongConLessThan300(page, 25);

		// Thêm dữ liệu vào model để hiển thị trong view
		model.addAttribute("books", booksPage.getContent()); // Danh sách sách trong trang hiện tại
		model.addAttribute("currentPage", page); // Trang hiện tại
		model.addAttribute("totalPages", booksPage.getTotalPages()); // Tổng số trang

		return "books/best-seller";
	}

	@GetMapping("/flash-sales")
	public String showBookFlashSales(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "25") int size, Model model) {
		Page<Sach> booksPage = sach1service.getBooksWithSoLuongConGreaterThan700(page, 25);

		// Thêm dữ liệu vào model để hiển thị trong view
		model.addAttribute("books", booksPage.getContent()); // Danh sách sách trong trang hiện tại
		model.addAttribute("currentPage", page); // Trang hiện tại
		model.addAttribute("totalPages", booksPage.getTotalPages());
		return "books/flash-sales";
	}
}