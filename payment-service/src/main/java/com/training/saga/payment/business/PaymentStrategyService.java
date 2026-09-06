package com.training.saga.payment.business;

import com.training.saga.payment.core.PaymentMethod;

import java.math.BigDecimal;

public interface PaymentStrategyService {

    PaymentMethod getPaymentMethod();

    void processPayment(BigDecimal amount);
}
