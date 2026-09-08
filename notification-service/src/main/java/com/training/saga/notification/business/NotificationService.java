package com.training.saga.notification.business;

import com.training.saga.notification.api.dto.NotificationResponse;
import com.training.saga.notification.api.dto.SendNotificationRequest;

public interface NotificationService {

    NotificationResponse sendNotification(SendNotificationRequest request);
}
