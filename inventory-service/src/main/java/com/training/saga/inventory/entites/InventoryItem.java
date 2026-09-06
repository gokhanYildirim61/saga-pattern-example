package com.training.saga.inventory.entites;

import com.training.saga.common.entites.BaseEntity;
import com.training.saga.inventory.core.InventoryStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "inventory_item")
@Getter
@Setter
public class InventoryItem extends BaseEntity {

    private String brand;

    private String model;

    @Column(unique = true)
    private String imei;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private InventoryStatus status = InventoryStatus.AVAILABLE;
}
