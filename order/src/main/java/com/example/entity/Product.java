package com.example.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Product {
    private final String name;
    private final double price;
    private final String category;
    private final String tags;
}
