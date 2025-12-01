package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private String orderId;
    private String timestamp;
    private String customerId;
    private String productId;

    @Embedded
    private Customer customer;

    @Embedded
    private Product product;

}
