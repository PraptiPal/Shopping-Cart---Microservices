package com.microservice.cart.CartService.controller;

import com.microservice.cart.CartService.entity.Cart;
import com.microservice.cart.CartService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/all-items")
    public ResponseEntity<List<Cart>> getAllCartItems(){
        return new ResponseEntity<>(cartService.getCartItems(), HttpStatus.OK);
    }
}
