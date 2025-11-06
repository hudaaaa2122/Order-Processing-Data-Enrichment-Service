package com.example.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Customer {
    private final String name;
    private final String street;
    private final String zip;
    private final String country;
}
