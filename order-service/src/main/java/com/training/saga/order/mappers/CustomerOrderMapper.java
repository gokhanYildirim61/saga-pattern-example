package com.training.saga.order.mappers;

import com.training.saga.order.api.dto.CreateCustomerOrderRequest;
import com.training.saga.order.api.dto.CustomerOrderResponse;
import com.training.saga.order.entites.CustomerOrder;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrderMapper {

    public CustomerOrder toEntity(CreateCustomerOrderRequest request) {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomerId(request.getCustomerId());
        customerOrder.setInventoryItemId(request.getInventoryItemId());
        customerOrder.setTotalAmount(request.getTotalAmount());

        return customerOrder;
    }

    public CustomerOrderResponse toResponse(CustomerOrder customerOrder) {
        return new CustomerOrderResponse(
                customerOrder.getId(),
                customerOrder.getCustomerId(),
                customerOrder.getInventoryItemId(),
                customerOrder.getTotalAmount(),
                customerOrder.getStatus()
        );
    }
}
