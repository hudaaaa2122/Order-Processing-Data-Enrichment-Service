package com.example.entity;

import jakarta.persistence.*;
import lombok.*;


@RequiredArgsConstructor
@Getter
@Setter
@Embeddable
public class Customer {
    private String cId;
    private String customerName;
    private String customerStreet;
    private String customerZip;
    private String customerCountry;

}

