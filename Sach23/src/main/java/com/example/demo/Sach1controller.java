/*
 * package com.example.demo;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import java.util.*;
 * 
 * @Controller
 * 
 * @RequestMapping public class Sach1controller {
 * 
 * @Autowired private Sach1repository repo;
 * 
 * @GetMapping({"", "/"})
 * 
 * public String showsach(Model model){ List<Sach1> books = repo.findAll();
 * model.addAttribute("books", books); return "index1"; } }
 */



package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;



@Controller
@RequestMapping("/books")
public class Sach1controller {

    @Autowired
    private Sach1service sach1service;
    
    @GetMapping("/search")
    public String search(@RequestParam String tenSach, Model model) {
        List<Sach1> books = sach1service.searchByTenSach(tenSach);  // Gọi service để lấy dữ liệu sách
        model.addAttribute("books", books);  // Truyền danh sách sách vào model
        return "books/search";  // Trả về trang searchPage để hiển thị kết quả
    }
    @GetMapping({"", "/"})
    public String showsach(Model model, 
                           @RequestParam(defaultValue = "1") int page, 
                           @RequestParam(defaultValue = "10") int size) 
    {
        // Lấy trang sách từ service
        Page<Sach1> booksPage = sach1service.getBooksByPage(page, size);

        // Thêm dữ liệu vào model để hiển thị trong view
        model.addAttribute("books", booksPage.getContent());      
        model.addAttribute("currentPage", page);                   
        model.addAttribute("totalPages", booksPage.getTotalPages()); 

        return "books/index3";  
    }
    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("sach1dto", new Sach1DTO());  
        return "books/createbook";  
    }

    //Them Sach
    @PostMapping("/create")
    public String createBook(
    		@Valid @ModelAttribute ("sach1dto")Sach1DTO sach1dto,
    		BindingResult result) {
       
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
    	Optional<Sach1> sach1 = sach1service.findById(MaSach);
        if (sach1.isPresent()) {
            Sach1DTO sach1dto = new Sach1DTO();
            sach1dto.setMaSach(sach1.get().getMaSach());
            sach1dto.setTenSach(sach1.get().getTenSach());
            sach1dto.setGiaGoc(sach1.get().getGiaGoc());
            
            sach1dto.setGiaKM(sach1.get().getGiaKM());
            sach1dto.setTenTG(sach1.get().getTenTG());
            sach1dto.setTenDoiTuong(sach1dto.getTenDoiTuong());
            sach1dto.setSoTrang(sach1.get().getSoTrang());
            sach1dto.setSoLuongCon(sach1.get().getSoLuongCon());
            sach1dto.setLinkAnh(sach1.get().getLinkAnh());
            sach1dto.setMaDM(sach1.get().getMaDM());
            model.addAttribute("sach1dto", sach1dto);
            return "books/edit";
        }
        return "redirect:/books";
    }
    @PostMapping("/edit")
    public String editBook(@Valid @ModelAttribute("sach1dto") Sach1DTO sach1dto,
                           BindingResult result) {
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
    

    
    @GetMapping("/high-stock")
    public String showBooks(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "30") int size,
            Model model
        ) {
            // Lấy danh sách sách tồn kho > 700 với phân trang
            Page<Sach1> booksPage = sach1service.getBooksWithSoLuongConGreaterThan700(page, 30);

            // Thêm dữ liệu vào model để hiển thị trong view
            model.addAttribute("books", booksPage.getContent());  // Danh sách sách trong trang hiện tại
            model.addAttribute("currentPage", page);              // Trang hiện tại
            model.addAttribute("totalPages", booksPage.getTotalPages()); // Tổng số trang

            return "books/high-stock";  
        }
    

    @GetMapping("/best-seller")
    public String showBookBest(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "25") int size,
            Model model
        ) {
            // Lấy danh sách sách tồn kho > 700 với phân trang
            Page<Sach1> booksPage = sach1service.getBooksWithSoLuongConLessThan300(page, 25);

            // Thêm dữ liệu vào model để hiển thị trong view
            model.addAttribute("books", booksPage.getContent());  // Danh sách sách trong trang hiện tại
            model.addAttribute("currentPage", page);              // Trang hiện tại
            model.addAttribute("totalPages", booksPage.getTotalPages()); // Tổng số trang

            return "books/best-seller";  
        }
    @GetMapping("/flash-sales")
    public String showBookFlashSales(
    		@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "25") int size,
            Model model
    		) {
    	Page<Sach1> booksPage = sach1service.getBooksWithSoLuongConGreaterThan700(page, 25);

        // Thêm dữ liệu vào model để hiển thị trong view
        model.addAttribute("books", booksPage.getContent());  // Danh sách sách trong trang hiện tại
        model.addAttribute("currentPage", page);              // Trang hiện tại
        model.addAttribute("totalPages", booksPage.getTotalPages());
    	return "books/flash-sales"; 
    }
 }





