package com.training.saga.payment.business;

import com.training.saga.payment.core.PaymentMethod;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IyzicoPaymentStrategyServiceImpl implements PaymentStrategyService{

    @Override
    public PaymentMethod getPaymentMethod() {
        return PaymentMethod.IYZICO;
    }

    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Iyzico ile odeme alindi: " + amount);
    }
}
