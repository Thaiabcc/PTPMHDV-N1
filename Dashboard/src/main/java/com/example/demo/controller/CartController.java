package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CartItem;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public List<CartItem> getAllItems() {
        return cartService.getAllItems();
    }

    @PostMapping
    public CartItem addItem(@RequestBody CartItem item) {
        return cartService.addItem(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeItem(@PathVariable Long id) {
        cartService.removeItem(id);
        return ResponseEntity.noContent().build();
    }
}