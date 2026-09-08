package com.training.saga.notification.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class SendNotificationRequest {

    @NotNull
    private UUID orderId;

    @NotNull
    private UUID customerId;

    @NotBlank
    private String type;

    @NotBlank
    private String message;
}
