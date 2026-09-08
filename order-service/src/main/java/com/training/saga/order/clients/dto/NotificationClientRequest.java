package com.training.saga.order.clients.dto;

import java.util.UUID;

public record NotificationClientRequest(
        UUID orderId,
        UUID customerId,
        String type,
        String message
) {
}
