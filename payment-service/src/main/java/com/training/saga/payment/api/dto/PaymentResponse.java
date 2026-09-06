package com.training.saga.payment.api.dto;

import com.training.saga.payment.core.PaymentMethod;
import com.training.saga.payment.core.PaymentStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class PaymentResponse {

    private final UUID paymentId;
    private final UUID orderId;
    private final BigDecimal amount;
    private final PaymentMethod paymentMethod;
    private final PaymentStatus status;

    public PaymentResponse(UUID paymentId,
                           UUID orderId,
                           BigDecimal amount,
                           PaymentMethod paymentMethod,
                           PaymentStatus status) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }
}
