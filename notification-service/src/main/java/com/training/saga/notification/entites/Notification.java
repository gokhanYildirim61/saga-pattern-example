package com.training.saga.notification.entites;

import com.training.saga.common.entites.BaseEntity;
import com.training.saga.notification.core.NotificationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "notification")
@Getter
@Setter
public class Notification extends BaseEntity {

    private UUID orderId;

    private UUID customerId;

    private String type;

    private String message;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status = NotificationStatus.SENT;
}
