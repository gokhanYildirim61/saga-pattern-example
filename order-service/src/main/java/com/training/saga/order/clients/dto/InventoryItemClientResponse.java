package com.training.saga.order.clients.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record InventoryItemClientResponse(
        UUID id,
        String brand,
        String model,
        String imei,
        BigDecimal price,
        String status
) {
}
