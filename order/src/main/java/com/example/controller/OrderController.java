package com.example.controller;

import com.example.dto.OrderDetails;
import com.example.dto.OrderResponse;
import com.example.entity.Order;
import com.example.dto.OrderRequest;
import com.example.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponse createOrder(@RequestBody final OrderRequest payload) {
        return orderService.processOrder(payload);
    }

    @GetMapping("/{orderId}")
    public OrderDetails getOrder(@PathVariable("orderId") final String orderId) {
        return orderService.getOrderById(orderId);
        }
}

