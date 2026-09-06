package com.training.saga.inventory.business;

import com.training.saga.inventory.api.dto.CreateInventoryItemRequest;
import com.training.saga.inventory.api.dto.InventoryItemResponse;

import java.util.UUID;

public interface InventoryItemService {

    InventoryItemResponse createItem(CreateInventoryItemRequest request);

    InventoryItemResponse getItemById(UUID id);

    InventoryItemResponse reserveItem(UUID id);

    InventoryItemResponse sellItem(UUID id);

    InventoryItemResponse releaseItem(UUID id);
}
