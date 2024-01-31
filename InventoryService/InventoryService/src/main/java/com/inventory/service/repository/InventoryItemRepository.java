package com.inventory.service.repository;

import com.inventory.service.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryItemRepository extends JpaRepository<InventoryItem,Long> {
    Optional<InventoryItem> findByProductCode(String productCode);
}
