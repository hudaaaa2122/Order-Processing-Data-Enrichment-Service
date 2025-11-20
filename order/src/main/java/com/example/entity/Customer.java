package com.example.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private String id;
    private  String name;
    private  String street;
    private  String zip;
    private  String country;

    }

