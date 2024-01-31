package com.microservice.cart.CartService.service.impl;

import com.microservice.cart.CartService.entity.Cart;
import com.microservice.cart.CartService.repository.CartRepository;
import com.microservice.cart.CartService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getCartItems() {
        return cartRepository.findAll();
    }
}
