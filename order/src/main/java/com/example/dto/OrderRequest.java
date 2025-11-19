package com.example.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@RequiredArgsConstructor
public class OrderRequest {
    private String orderId;
    private String customerId;
    private String productId;
    private String  timestamp;

}
