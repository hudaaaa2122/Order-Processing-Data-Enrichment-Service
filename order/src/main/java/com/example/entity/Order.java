package com.example.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Order {
    private final String orderId;
     Customer customer;
     Product product;
}
