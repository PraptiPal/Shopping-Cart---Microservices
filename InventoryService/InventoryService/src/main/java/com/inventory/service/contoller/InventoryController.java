package com.inventory.service.contoller;

import com.inventory.service.entity.InventoryItem;
import com.inventory.service.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/api/inventory/{productCode}")
    public ResponseEntity<InventoryItem> findInventoryByProductCode(@PathVariable("productCode") String productCode) {
        log.info("Finding inventory for product code :"+productCode);
        return new ResponseEntity<>(inventoryService.findInventoryByProductCode(productCode),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InventoryItem>> getAllInventory(){
        return new ResponseEntity<>(inventoryService.getAllInventory(),HttpStatus.OK);
    }
}
