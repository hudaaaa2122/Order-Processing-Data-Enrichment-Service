package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Product {
    private  String id;
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
