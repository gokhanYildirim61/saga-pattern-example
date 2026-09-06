package com.training.saga.inventory.api.dto;

import com.training.saga.inventory.core.InventoryStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class InventoryItemResponse {

    private final UUID id;
    private final String brand;
    private final String model;
    private final String imei;
    private final BigDecimal price;
    private final InventoryStatus status;

    public InventoryItemResponse(UUID id,
                                 String brand,
                                 String model,
                                 String imei,
                                 BigDecimal price,
                                 InventoryStatus status) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.imei = imei;
        this.price = price;
        this.status = status;
    }
}
