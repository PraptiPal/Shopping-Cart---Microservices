package com.microservice.cart.CartService.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.microservice.catalog.entity.Product;

@Entity
@Table(name = "cart")
public class Cart {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private List<Product> cartList = new ArrayList<Product>();

}
