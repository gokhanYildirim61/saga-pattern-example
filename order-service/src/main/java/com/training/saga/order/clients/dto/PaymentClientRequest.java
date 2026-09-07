package com.training.saga.order.clients.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentClientRequest(
        UUID orderId,
        BigDecimal amount,
        String paymentMethod
) {
}
