package com.training.saga.payment.business;

import com.training.saga.payment.core.PaymentMethod;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaynetPaymentStrategyServiceImpl implements PaymentStrategyService{

    @Override
    public PaymentMethod getPaymentMethod() {
        return PaymentMethod.PAYNET;
    }

    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Paynet ile odeme alindi: " + amount);
    }
}
