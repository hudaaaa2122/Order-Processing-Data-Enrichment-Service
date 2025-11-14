package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private  String orderId;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_customer_id")
    private  Customer customer;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "product_product_id")
    private Product product;

     public Order(String orderId) {
         this.orderId = orderId;
     }
}
