package com.training.saga.order.clients.dto;

import java.util.UUID;

public record CustomerClientResponse(
        UUID id,
        String firstName,
        String lastName,
        String email,
        Boolean active
) {
}
