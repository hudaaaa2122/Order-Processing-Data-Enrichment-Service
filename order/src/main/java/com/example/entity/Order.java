package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
    private String customerName;
    private String customerStreet;
    private String customerZip;
    private String customerCountry;

    private String productId;
    private String productName;
    private Double productPrice;
    private String productCategory;
    private String productTags;

    @Version
    private Long version;


}
