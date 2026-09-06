package com.training.saga.order.api.dto;

import com.training.saga.order.core.OrderStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class CustomerOrderResponse {

    private final UUID id;
    private final UUID customerId;
    private final UUID inventoryItemId;
    private final BigDecimal totalAmount;
    private final OrderStatus status;

    public CustomerOrderResponse(UUID id,
                                 UUID customerId,
                                 UUID inventoryItemId,
                                 BigDecimal totalAmount,
                                 OrderStatus status) {
        this.id = id;
        this.customerId = customerId;
        this.inventoryItemId = inventoryItemId;
        this.totalAmount = totalAmount;
        this.status = status;
    }
}
