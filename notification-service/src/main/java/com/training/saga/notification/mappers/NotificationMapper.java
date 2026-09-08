package com.training.saga.notification.mappers;

import com.training.saga.notification.api.dto.NotificationResponse;
import com.training.saga.notification.api.dto.SendNotificationRequest;
import com.training.saga.notification.core.NotificationStatus;
import com.training.saga.notification.entites.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public Notification toEntity(SendNotificationRequest request) {
        Notification notification = new Notification();
        notification.setOrderId(request.getOrderId());
        notification.setCustomerId(request.getCustomerId());
        notification.setType(request.getType());
        notification.setMessage(request.getMessage());
        notification.setStatus(NotificationStatus.SENT);

        return notification;
    }

    public NotificationResponse toResponse(Notification notification) {
        return new NotificationResponse(
                notification.getId(),
                notification.getOrderId(),
                notification.getCustomerId(),
                notification.getType(),
                notification.getMessage(),
                notification.getStatus()
        );
    }
}
