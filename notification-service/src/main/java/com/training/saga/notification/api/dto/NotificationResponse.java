package com.training.saga.notification.api.dto;

import com.training.saga.notification.core.NotificationStatus;
import lombok.Getter;

import java.util.UUID;

@Getter
public class NotificationResponse {

    private final UUID id;
    private final UUID orderId;
    private final UUID customerId;
    private final String type;
    private final String message;
    private final NotificationStatus status;

    public NotificationResponse(UUID id,
                                UUID orderId,
                                UUID customerId,
                                String type,
                                String message,
                                NotificationStatus status) {
        this.id = id;
        this.orderId = orderId;
        this.customerId = customerId;
        this.type = type;
        this.message = message;
        this.status = status;
    }
}
