package com.example.service;

import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.entity.OrderRequest;
import com.example.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final CustomerService customerService;
    private final ProductService productService;

    public OrderService(CustomerService customerService, ProductService productService) {
        this.customerService = customerService;
        this.productService = productService;
    }


    public Order getOrderById (String orderId){
        Order order = new Order(orderId);
        Customer customer = customerService.getCustomer(orderId);
        Product product = productService.getProduct(orderId);
        order.setCustomer(customer);
        order.setProduct(product);
        return order;
    }

    public OrderRequest processOrder(OrderRequest payload){
        return payload;

    }
}
