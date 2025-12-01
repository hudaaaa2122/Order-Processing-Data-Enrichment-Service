package com.example.controller;

import com.example.dto.OrderRequest;
import com.example.dto.OrderResponse;
import com.example.entity.Order;
import com.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderResponse createOrder(@RequestBody final OrderRequest payload) {
        Order order = new Order();
        order.setOrderId(payload.getOrderId());
        order.setTimestamp(payload.getTimestamp());
        order.setCustomerId(payload.getCustomerId());
        order.setProductId(payload.getProductId());
        Order saved = orderService.processOrder(order);
        return getOrderResponse(saved);
    }
    @GetMapping("/{orderId}")
    public OrderResponse getOrder(@PathVariable("orderId") final String orderId) {
        Order order = orderService.getOrderById(orderId);
        return getOrderResponse(order);
    }
    private OrderResponse getOrderResponse(Order saved) {
        OrderResponse response = new OrderResponse();
        response.setOrderId(saved.getOrderId());
        response.setTimestamp(saved.getTimestamp());


        if (saved.getCustomer() != null) {
            response.setCustomerId(saved.getCustomer().getCId());
            response.setCustomerName(saved.getCustomer().getCustomerName());
            response.setCustomerStreet(saved.getCustomer().getCustomerStreet());
            response.setCustomerZip(saved.getCustomer().getCustomerZip());
            response.setCustomerCountry(saved.getCustomer().getCustomerCountry());
        }
        if (saved.getProduct() != null) {
            response.setProductId(saved.getProduct().getPId());
            response.setProductName(saved.getProduct().getProductName());
            response.setProductPrice(saved.getProduct().getProductPrice());
            response.setProductCategory(saved.getProduct().getProductCategory());
            response.setProductTags(saved.getProduct().getProductTags());
        }
        return response;
    }

}



