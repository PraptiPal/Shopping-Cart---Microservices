package com.inventory.service.service.impl;

import com.inventory.service.entity.InventoryItem;
import com.inventory.service.repository.InventoryItemRepository;
import com.inventory.service.service.InventoryService;
import com.microservice.catalog.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryItemRepository inventoryItemRepository;


    @Override
    public List<InventoryItem> getAllInventory() {
        return inventoryItemRepository.findAll();
    }

    @Override
    public InventoryItem findInventoryByProductCode(String productCode) {

        log.info("Finding inventory for product code :"+productCode);

        Optional<InventoryItem> inventoryItem =
                inventoryItemRepository.findByProductCode(productCode);

        if(inventoryItem.isPresent()) {
            return inventoryItem.get();
        } else {
            throw new ProductNotFoundException();
        }
    }
}
