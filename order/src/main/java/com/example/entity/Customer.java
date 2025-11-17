package com.example.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private  String name;
    private  String street;
    private  String zip;
    private  String country;


    public Customer( String name, String street, String zip, String country) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.country = country;
    }
}
