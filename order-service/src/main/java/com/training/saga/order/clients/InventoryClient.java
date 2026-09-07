package com.training.saga.order.clients;

import com.training.saga.order.clients.dto.InventoryItemClientResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Component
public class InventoryClient {

    private final RestClient restClient;

    public InventoryClient(RestClient.Builder restClientBuilder,
                           @Value("${inventory-service.base-url}") String baseUrl) {
        this.restClient = restClientBuilder.baseUrl(baseUrl).build();
    }

    public InventoryItemClientResponse reserveItem(UUID inventoryItemId) {
        return patchInventoryItem(inventoryItemId, "reserve");
    }

    public InventoryItemClientResponse sellItem(UUID inventoryItemId) {
        return patchInventoryItem(inventoryItemId, "sell");
    }

    public InventoryItemClientResponse releaseItem(UUID inventoryItemId) {
        return patchInventoryItem(inventoryItemId, "release");
    }

    private InventoryItemClientResponse patchInventoryItem(UUID inventoryItemId, String action) {
        return restClient.patch()
                .uri("/api/v1/inventory-items/{inventoryItemId}/{action}", inventoryItemId, action)
                .retrieve()
                .body(InventoryItemClientResponse.class);
    }
}
