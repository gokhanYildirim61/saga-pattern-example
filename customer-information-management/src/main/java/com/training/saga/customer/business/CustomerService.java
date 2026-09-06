package com.training.saga.customer.business;

import com.training.saga.customer.api.dto.CreateCustomerRequest;
import com.training.saga.customer.api.dto.CustomerResponse;

import java.util.UUID;

public interface CustomerService {

    CustomerResponse createCustomer(CreateCustomerRequest request);

    CustomerResponse getCustomerById(UUID id);
}
