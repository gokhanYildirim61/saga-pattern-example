package com.training.saga.notification.business;

import com.training.saga.notification.api.dto.NotificationResponse;
import com.training.saga.notification.api.dto.SendNotificationRequest;
import com.training.saga.notification.dataAccess.NotificationRepository;
import com.training.saga.notification.entites.Notification;
import com.training.saga.notification.mappers.NotificationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public NotificationServiceImpl(NotificationRepository notificationRepository,
                                   NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    @Transactional
    public NotificationResponse sendNotification(SendNotificationRequest request) {
        Notification notification = notificationMapper.toEntity(request);
        Notification savedNotification = notificationRepository.save(notification);

        System.out.println("Notification sent for order: " + savedNotification.getOrderId());

        return notificationMapper.toResponse(savedNotification);
    }
}
