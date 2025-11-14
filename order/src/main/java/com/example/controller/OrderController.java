package com.example.controller;

import com.example.entity.Order;
import com.example.entity.OrderRequest;
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
    public OrderRequest recieveOrder(@RequestBody final OrderRequest payload) {
        OrderRequest orderProcessing = orderService.processOrder(payload);
        return orderProcessing;
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable("orderId") final String orderId) {
        return orderService.getOrderById(orderId);
        }
}

