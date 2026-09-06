package com.training.saga.customer.api.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CustomerResponse {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Boolean active;

    public CustomerResponse(UUID id,
                            String firstName,
                            String lastName,
                            String email,
                            Boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
    }
}
