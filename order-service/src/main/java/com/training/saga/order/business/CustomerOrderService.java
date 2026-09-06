package com.training.saga.order.business;

import com.training.saga.order.api.dto.CreateCustomerOrderRequest;
import com.training.saga.order.api.dto.CustomerOrderResponse;

public interface CustomerOrderService {

    CustomerOrderResponse createOrder(CreateCustomerOrderRequest request);
}
