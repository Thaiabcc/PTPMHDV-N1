package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CartItem;
import com.example.demo.repository.CartItemRepository;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getAllItems() {
        return cartItemRepository.findAll();
    }

    public CartItem addItem(CartItem item) {
        return cartItemRepository.save(item);
    }

    public void removeItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}