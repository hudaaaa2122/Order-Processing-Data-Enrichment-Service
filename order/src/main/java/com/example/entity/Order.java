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
    private  String orderId;

    private Date timestamp;
    private String CustomerId;
    private String  ProductId;

   private String customerName;
   private String customerStreet;
   private String customerZip;
   private String customerCountry;

    private String productName;
    private double productPrice;
    private String productCategory;
    private String productTags;


    public Order(String orderId) {
         this.orderId = orderId;
    }


}
