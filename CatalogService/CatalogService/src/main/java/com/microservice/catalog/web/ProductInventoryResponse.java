package com.microservice.catalog.web;

import lombok.Data;

@Data
public class ProductInventoryResponse {

    private String productCode;
    private Integer availableQuantity = 0;
}
