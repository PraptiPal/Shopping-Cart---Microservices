package com.microservice.cart.CartService.service;

import com.microservice.cart.CartService.entity.Cart;

import java.util.List;

public interface CartService {

    public List<Cart> getCartItems();
}
