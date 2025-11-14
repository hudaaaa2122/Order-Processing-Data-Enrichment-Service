package com.example.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

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
