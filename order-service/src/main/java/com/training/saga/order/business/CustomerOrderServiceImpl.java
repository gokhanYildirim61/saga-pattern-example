package com.training.saga.order.business;

import com.training.saga.order.api.dto.CreateCustomerOrderRequest;
import com.training.saga.order.api.dto.CustomerOrderResponse;
import com.training.saga.order.core.OrderStatus;
import com.training.saga.order.dataAccess.CustomerOrderRepository;
import com.training.saga.order.entites.CustomerOrder;
import com.training.saga.order.mappers.CustomerOrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerOrderMapper customerOrderMapper;

    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository,
                                    CustomerOrderMapper customerOrderMapper) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerOrderMapper = customerOrderMapper;
    }

    @Override
    @Transactional
    public CustomerOrderResponse createOrder(CreateCustomerOrderRequest request) {
        CustomerOrder customerOrder = customerOrderMapper.toEntity(request);
        CustomerOrder savedOrder = customerOrderRepository.save(customerOrder);

        return customerOrderMapper.toResponse(savedOrder);
    }

    @Override
    @Transactional
    public CustomerOrderResponse markInventoryReserved(UUID orderId) {
        return updateStatus(orderId, OrderStatus.INVENTORY_RESERVED);
    }

    @Override
    @Transactional
    public CustomerOrderResponse markPaymentPending(UUID orderId) {
        return updateStatus(orderId, OrderStatus.PAYMENT_PENDING);
    }

    @Override
    @Transactional
    public CustomerOrderResponse confirmOrder(UUID orderId) {
        return updateStatus(orderId, OrderStatus.CONFIRMED);
    }

    @Override
    @Transactional
    public CustomerOrderResponse cancelOrder(UUID orderId) {
        return updateStatus(orderId, OrderStatus.CANCELLED);
    }

    private CustomerOrderResponse updateStatus(UUID orderId, OrderStatus status) {
        CustomerOrder customerOrder = customerOrderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        customerOrder.setStatus(status);

        return customerOrderMapper.toResponse(customerOrder);
    }
}
