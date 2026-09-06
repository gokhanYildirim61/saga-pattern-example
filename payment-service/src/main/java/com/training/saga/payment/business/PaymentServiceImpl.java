package com.training.saga.payment.business;

import com.training.saga.payment.api.dto.PaymentRequest;
import com.training.saga.payment.api.dto.PaymentResponse;
import com.training.saga.payment.core.PaymentMethod;
import com.training.saga.payment.core.PaymentStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl {

    private final Map<PaymentMethod, PaymentStrategyService> paymentStrategyServiceMap;

    public PaymentServiceImpl(List<PaymentStrategyService> paymentStrategyServices) {
        this.paymentStrategyServiceMap = paymentStrategyServices.stream()
                .collect(Collectors.toMap(PaymentStrategyService::getPaymentMethod, Function.identity()));
    }

    public PaymentResponse pay(PaymentRequest request) {
        PaymentStrategyService paymentStrategyService = paymentStrategyServiceMap.get(request.getPaymentMethod());

        if (paymentStrategyService == null) {
            throw new IllegalArgumentException("Payment method not found");
        }

        paymentStrategyService.processPayment(request.getAmount());

        return new PaymentResponse(
                UUID.randomUUID(),
                request.getOrderId(),
                request.getAmount(),
                request.getPaymentMethod(),
                PaymentStatus.SUCCESS
        );
    }
}
