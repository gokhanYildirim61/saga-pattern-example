package com.training.saga.order.clients.dto;

import java.util.UUID;

public record NotificationClientResponse(
        UUID id,
        UUID orderId,
        UUID customerId,
        String type,
        String message,
        String status
) {
}
