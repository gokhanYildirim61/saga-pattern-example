package com.training.saga.payment.business;

import com.training.saga.payment.core.PaymentMethod;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FakeFailPaymentStrategyServiceImpl implements PaymentStrategyService {

    @Override
    public PaymentMethod getPaymentMethod() {
        return PaymentMethod.FAKE_FAIL;
    }

    @Override
    public void processPayment(BigDecimal amount) {
        throw new IllegalStateException("Payment failed intentionally");
    }
}
