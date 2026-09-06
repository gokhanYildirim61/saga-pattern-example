package com.training.saga.order.entites;

import com.training.saga.common.entites.BaseEntity;
import com.training.saga.order.core.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "customer_order")
@Getter
@Setter
public class CustomerOrder extends BaseEntity {

    private UUID customerId;

    private UUID inventoryItemId;

    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;
}
