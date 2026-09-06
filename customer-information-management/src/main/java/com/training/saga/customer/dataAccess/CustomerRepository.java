package com.training.saga.customer.dataAccess;

import com.training.saga.customer.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
