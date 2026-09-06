package com.training.saga.order.business;

import com.training.saga.order.api.dto.CreateCustomerOrderRequest;
import com.training.saga.order.api.dto.CustomerOrderResponse;
import com.training.saga.order.dataAccess.CustomerOrderRepository;
import com.training.saga.order.entites.CustomerOrder;
import com.training.saga.order.mappers.CustomerOrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
