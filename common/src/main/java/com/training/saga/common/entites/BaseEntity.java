package com.training.saga.common.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime createdDate;


    private LocalDateTime updatedDate;

    private LocalDateTime deletedDate;


    @PrePersist
    protected void onCreate(){
        createdDate=LocalDateTime.now();
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedDate=LocalDateTime.now();
    }

}

