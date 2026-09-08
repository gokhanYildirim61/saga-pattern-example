package com.training.saga.order.clients;

import com.training.saga.order.clients.dto.NotificationClientRequest;
import com.training.saga.order.clients.dto.NotificationClientResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class NotificationClient {

    private final RestClient restClient;

    public NotificationClient(RestClient.Builder restClientBuilder,
                              @Value("${notification-service.base-url}") String baseUrl) {
        this.restClient = restClientBuilder.baseUrl(baseUrl).build();
    }

    public NotificationClientResponse sendNotification(NotificationClientRequest request) {
        return restClient.post()
                .uri("/api/v1/notifications")
                .body(request)
                .retrieve()
                .body(NotificationClientResponse.class);
    }
}
