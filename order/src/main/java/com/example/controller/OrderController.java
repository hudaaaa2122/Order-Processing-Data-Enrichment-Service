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
    public OrderRequest recieveOrder(@RequestBody final Order payload) {
        return orderService.processOrder(payload);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable("orderId") final String orderId) {
        return orderService.getOrderById(orderId);
        }
}

