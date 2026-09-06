package com.training.saga.inventory.api;

import com.training.saga.inventory.api.dto.CreateInventoryItemRequest;
import com.training.saga.inventory.api.dto.InventoryItemResponse;
import com.training.saga.inventory.business.InventoryItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/inventory-items")
public class InventoryItemController {

    private final InventoryItemService inventoryItemService;

    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    @PostMapping
    public ResponseEntity<InventoryItemResponse> createItem(
            @Valid @RequestBody CreateInventoryItemRequest request) {
        InventoryItemResponse response = inventoryItemService.createItem(request);

        return ResponseEntity
                .created(URI.create("/api/v1/inventory-items/" + response.getId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItemResponse> getItemById(@PathVariable UUID id) {
        return ResponseEntity.ok(inventoryItemService.getItemById(id));
    }

    @PatchMapping("/{id}/reserve")
    public ResponseEntity<InventoryItemResponse> reserveItem(@PathVariable UUID id) {
        return ResponseEntity.ok(inventoryItemService.reserveItem(id));
    }

    @PatchMapping("/{id}/sell")
    public ResponseEntity<InventoryItemResponse> sellItem(@PathVariable UUID id) {
        return ResponseEntity.ok(inventoryItemService.sellItem(id));
    }

    @PatchMapping("/{id}/release")
    public ResponseEntity<InventoryItemResponse> releaseItem(@PathVariable UUID id) {
        return ResponseEntity.ok(inventoryItemService.releaseItem(id));
    }
}
