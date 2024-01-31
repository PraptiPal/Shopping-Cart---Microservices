package com.microservice.catalog.service.impl;

import com.microservice.catalog.entity.Product;
import com.microservice.catalog.repository.ProductRepository;
import com.microservice.catalog.service.ProductService;
import com.microservice.catalog.web.ProductInventoryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RestTemplate restTemplate;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductByCode(String code) {
        Optional<Product> productOptional = productRepository.findByCode(code);
        if(productOptional.isPresent()) {
            log.info("Fetching inventory level for product_code" + code);
            ResponseEntity<ProductInventoryResponse> itemResponseEntity =
                    restTemplate.getForEntity("http://inventory-service/pi/inventory/{code}",
                            ProductInventoryResponse.class, code);

            if (itemResponseEntity.getStatusCode() == HttpStatus.OK) {
                Integer quantity = itemResponseEntity.getBody().getAvailableQuantity();
                log.info("Available quantity: " + quantity);
                productOptional.get().setInStock(quantity > 0);
            } else {
                log.error("Unable to get inventory level for product code" + code +
                        ", StatusCode: " + itemResponseEntity.getStatusCode());
            }
        }
        return productOptional;
    }
}
