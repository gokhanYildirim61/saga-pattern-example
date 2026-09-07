package com.training.saga.order.clients;

import com.training.saga.order.clients.dto.PaymentClientRequest;
import com.training.saga.order.clients.dto.PaymentClientResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PaymentClient {

    private final RestClient restClient;

    public PaymentClient(RestClient.Builder restClientBuilder,
                         @Value("${payment-service.base-url}") String baseUrl) {
        this.restClient = restClientBuilder.baseUrl(baseUrl).build();
    }

    public PaymentClientResponse pay(PaymentClientRequest request) {
        return restClient.post()
                .uri("/api/v1/payments")
                .body(request)
                .retrieve()
                .body(PaymentClientResponse.class);
    }
}
