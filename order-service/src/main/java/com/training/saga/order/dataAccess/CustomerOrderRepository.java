package com.training.saga.order.dataAccess;

import com.training.saga.order.entites.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,UUID> {
}
