package com.training.saga.inventory.mappers;

import com.training.saga.inventory.api.dto.CreateInventoryItemRequest;
import com.training.saga.inventory.api.dto.InventoryItemResponse;
import com.training.saga.inventory.entites.InventoryItem;
import org.springframework.stereotype.Component;

@Component
public class InventoryItemMapper {

    public InventoryItem toEntity(CreateInventoryItemRequest request) {
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setBrand(request.getBrand());
        inventoryItem.setModel(request.getModel());
        inventoryItem.setImei(request.getImei());
        inventoryItem.setPrice(request.getPrice());

        return inventoryItem;
    }

    public InventoryItemResponse toResponse(InventoryItem inventoryItem) {
        return new InventoryItemResponse(
                inventoryItem.getId(),
                inventoryItem.getBrand(),
                inventoryItem.getModel(),
                inventoryItem.getImei(),
                inventoryItem.getPrice(),
                inventoryItem.getStatus()
        );
    }
}
