package com.training.saga.order.clients.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentClientResponse(
        UUID paymentId,
        UUID orderId,
        BigDecimal amount,
        String paymentMethod,
        String status
) {
}
