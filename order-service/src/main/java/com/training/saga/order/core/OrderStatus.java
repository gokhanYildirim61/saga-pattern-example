package com.training.saga.order.core;

public enum OrderStatus {
    PENDING,
    INVENTORY_RESERVED,
    PAYMENT_PENDING,
    CONFIRMED,
    CANCELLED
}
