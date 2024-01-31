package com.inventory.service.service;

import com.inventory.service.entity.InventoryItem;
import java.util.List;

public interface InventoryService {

    public List<InventoryItem> getAllInventory();

    public InventoryItem findInventoryByProductCode(String productCode);
}
