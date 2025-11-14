package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private  Long productId;
    private  String name;
    private  double price;
    private  String category;
    private  String tags;

    public Product(String name, double price, String category, String tags) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.tags = tags;
    }
}
