package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Embeddable
public class Product {
    private String pId;
    private String productName;
    private double productPrice;
    private String productCategory;
    private String productTags;
}
