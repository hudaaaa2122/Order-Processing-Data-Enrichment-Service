package com.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderResponse {
    private String orderId;
    private String timestamp;
    private String customerId;
    private String productId;
}
