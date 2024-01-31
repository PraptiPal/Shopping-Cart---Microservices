package com.microservice.cart.CartService.repository;

import com.microservice.cart.CartService.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
