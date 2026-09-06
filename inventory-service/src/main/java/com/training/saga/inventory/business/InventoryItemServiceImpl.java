package com.training.saga.inventory.business;

import com.training.saga.inventory.api.dto.CreateInventoryItemRequest;
import com.training.saga.inventory.api.dto.InventoryItemResponse;
import com.training.saga.inventory.core.InventoryStatus;
import com.training.saga.inventory.dataAccess.InventoryItemRepository;
import com.training.saga.inventory.entites.InventoryItem;
import com.training.saga.inventory.mappers.InventoryItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class InventoryItemServiceImpl implements InventoryItemService {

    private final InventoryItemRepository inventoryItemRepository;
    private final InventoryItemMapper inventoryItemMapper;

    public InventoryItemServiceImpl(InventoryItemRepository inventoryItemRepository,
                                    InventoryItemMapper inventoryItemMapper) {
        this.inventoryItemRepository = inventoryItemRepository;
        this.inventoryItemMapper = inventoryItemMapper;
    }

    @Override
    @Transactional
    public InventoryItemResponse createItem(CreateInventoryItemRequest request) {
        InventoryItem inventoryItem = inventoryItemMapper.toEntity(request);
        InventoryItem savedItem = inventoryItemRepository.save(inventoryItem);

        return inventoryItemMapper.toResponse(savedItem);
    }

    @Override
    @Transactional(readOnly = true)
    public InventoryItemResponse getItemById(UUID id) {
        InventoryItem inventoryItem = findItemById(id);

        return inventoryItemMapper.toResponse(inventoryItem);
    }

    @Override
    @Transactional
    public InventoryItemResponse reserveItem(UUID id) {
        InventoryItem inventoryItem = findItemById(id);

        if (inventoryItem.getStatus() != InventoryStatus.AVAILABLE) {
            throw new IllegalStateException("Inventory item is not available");
        }

        inventoryItem.setStatus(InventoryStatus.RESERVED);

        return inventoryItemMapper.toResponse(inventoryItem);
    }

    @Override
    @Transactional
    public InventoryItemResponse sellItem(UUID id) {
        InventoryItem inventoryItem = findItemById(id);

        if (inventoryItem.getStatus() != InventoryStatus.RESERVED) {
            throw new IllegalStateException("Inventory item must be reserved before selling");
        }

        inventoryItem.setStatus(InventoryStatus.SOLD);

        return inventoryItemMapper.toResponse(inventoryItem);
    }

    @Override
    @Transactional
    public InventoryItemResponse releaseItem(UUID id) {
        InventoryItem inventoryItem = findItemById(id);

        if (inventoryItem.getStatus() == InventoryStatus.RESERVED) {
            inventoryItem.setStatus(InventoryStatus.AVAILABLE);
        }

        return inventoryItemMapper.toResponse(inventoryItem);
    }

    private InventoryItem findItemById(UUID id) {
        return inventoryItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Inventory item not found"));
    }
}
