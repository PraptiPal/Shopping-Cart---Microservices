package com.microservice.catalog.service;

import com.microservice.catalog.entity.Product;
import java.util.List;
import java.util.Optional;


public interface ProductService {
    public List<Product> findAllProducts();

    public Optional<Product> findProductByCode(String code);
}
