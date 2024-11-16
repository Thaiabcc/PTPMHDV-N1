/*
 * package com.example.demo;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service; import java.util.List;
 * 
 * @Service public class Sach1service {
 * 
 * @Autowired private Sach1repository sach1repository; public List<Sach1>
 * getAllBooks(){ return sach1repository.findAll(); } }
 */



package com.example.demo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.NhaSach.Sach;

@Service
public class Sach1service {

    @Autowired
    private Sach1repository sach1repository;
    
    public List<Sach1> searchByTenSach(String tenSach) {
        return sach1repository.findByTenSachContainingIgnoreCase(tenSach);
    }
    
    //Create and save
    public Sach1 saveBook(Sach1DTO sach1dto) {
        Sach1 sach1 = new Sach1();
        sach1.setMaSach(sach1dto.getMaSach());
        sach1.setTenSach(sach1dto.getTenSach());
        sach1.setGiaGoc(sach1dto.getGiaGoc());
        sach1.setGiaKM(sach1dto.getGiaKM());
        sach1.setTenTG(sach1dto.getTenTG());
        sach1.setTenDoiTuong(sach1dto.getTenDoiTuong());
        sach1.setSoTrang(sach1dto.getSoTrang());
        sach1.setSoLuongCon(sach1dto.getSoLuongCon());
        sach1.setLinkAnh(sach1dto.getLinkAnh());

        return sach1repository.save(sach1);  
    }
    
    
     // Phân trang
    public Page<Sach1> getBooksByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);  
        return sach1repository.findAll(pageable);        
    }
	
	/*
	 * public List<Sach1> searchBooksByName(String keyword) { return
	 * sach1repository.findByTenSachContainingIgnoreCase(keyword); // Repository
	 * thực hiện tìm kiếm }
	 */
    
    //Update sach
    public Optional<Sach1> findById(String MaSach) {
        return sach1repository.findById(MaSach);
    }

    public void updateBook(Sach1DTO sach1dto) {
        Optional<Sach1> sachOpt = sach1repository.findById(sach1dto.getMaSach());
        if (sachOpt.isPresent()) {
            Sach1 sach1 = sachOpt.get();
            sach1.setTenSach(sach1dto.getTenSach());
            sach1.setGiaGoc(sach1dto.getGiaGoc());
            sach1.setGiaKM(sach1dto.getGiaKM());
            sach1.setTenTG(sach1dto.getTenTG());
            sach1.setTenDoiTuong(sach1dto.getTenDoiTuong());
            sach1.setSoTrang(sach1dto.getSoTrang());
            sach1.setSoLuongCon(sach1dto.getSoLuongCon());
            sach1.setLinkAnh(sach1dto.getLinkAnh());
            sach1.setMaDM(sach1dto.getMaDM());
            sach1repository.save(sach1);
        }
    }
    //Delete sach
    public void deleteBook(String MaSach) {
    	sach1repository.deleteById(MaSach);
    }
    //Xep hang
    public List<Sach1> getTopSellingBooks(int limit) {
        List<Sach1> allBooks = sach1repository.findAll();
        System.out.println("Total books found: " + allBooks.size()); // Debugging

        return allBooks.stream()
            .sorted(Comparator.comparingInt(book -> {
                try {
                    return Integer.parseInt(book.getSoLuongCon());
                } catch (NumberFormatException e) {
                    return Integer.MAX_VALUE; // Nếu không thể chuyển đổi, cho nó vào cuối danh sách
                }
            }))
            .limit(limit)
            .collect(Collectors.toList());
    }
   }



