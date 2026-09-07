package com.training.saga.order.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CreateCustomerOrderRequest {

    @NotNull
    private UUID customerId;

    @NotNull
    private UUID inventoryItemId;

    @NotNull
    @Positive
    private BigDecimal totalAmount;

    @NotBlank
    private String paymentMethod;
}
