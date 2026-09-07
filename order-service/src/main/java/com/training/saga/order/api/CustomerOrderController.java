package com.training.saga.order.api;

import com.training.saga.order.api.dto.CreateCustomerOrderRequest;
import com.training.saga.order.api.dto.CustomerOrderResponse;
import com.training.saga.order.saga.OrderSagaOrchestrator;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/orders")
public class CustomerOrderController {

    private final OrderSagaOrchestrator orderSagaOrchestrator;

    public CustomerOrderController(OrderSagaOrchestrator orderSagaOrchestrator) {
        this.orderSagaOrchestrator = orderSagaOrchestrator;
    }

    @PostMapping
    public ResponseEntity<CustomerOrderResponse> createOrder(
            @Valid @RequestBody CreateCustomerOrderRequest request) {
        CustomerOrderResponse response = orderSagaOrchestrator.start(request);

        return ResponseEntity
                .created(URI.create("/api/v1/orders/" + response.getId()))
                .body(response);
    }
}
