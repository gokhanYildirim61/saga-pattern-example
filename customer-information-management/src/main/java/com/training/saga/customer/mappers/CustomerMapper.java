package com.training.saga.customer.mappers;

import com.training.saga.customer.api.dto.CreateCustomerRequest;
import com.training.saga.customer.api.dto.CustomerResponse;
import com.training.saga.customer.entites.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());

        return customer;
    }

    public CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getActive()
        );
    }
}
