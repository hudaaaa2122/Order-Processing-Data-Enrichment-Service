package com.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class OrderDetails {
    private String orderId;
    private String timestamp;

    private String customerId;
    private String customerName;
    private String customerStreet;
    private String customerZip;
    private String customerCountry;

    private String productId;
    private String productName;
    private Double productPrice;
    private String productCategory;
    private String productTags;
}
