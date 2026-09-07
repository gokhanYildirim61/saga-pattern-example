package com.training.saga.order.clients;

import com.training.saga.order.clients.dto.CustomerClientResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Component
public class CustomerClient {

    private final RestClient restClient;

    public CustomerClient(RestClient.Builder restClientBuilder,
                          @Value("${customer-service.base-url}") String baseUrl) {
        this.restClient = restClientBuilder.baseUrl(baseUrl).build();
    }

    public CustomerClientResponse getCustomerById(UUID customerId) {
        return restClient.get()
                .uri("/api/v1/customers/{customerId}", customerId)
                .retrieve()
                .body(CustomerClientResponse.class);
    }
}
