package com.training.saga.order.business;

import com.training.saga.order.api.dto.CreateCustomerOrderRequest;
import com.training.saga.order.api.dto.CustomerOrderResponse;

import java.util.UUID;

public interface CustomerOrderService {

    CustomerOrderResponse createOrder(CreateCustomerOrderRequest request);

    CustomerOrderResponse markInventoryReserved(UUID orderId);

    CustomerOrderResponse markPaymentPending(UUID orderId);

    CustomerOrderResponse confirmOrder(UUID orderId);

    CustomerOrderResponse cancelOrder(UUID orderId);
}
