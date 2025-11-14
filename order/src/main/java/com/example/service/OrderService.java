package com.example.service;

import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.entity.OrderRequest;
import com.example.entity.Product;
import com.example.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class OrderService {
    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderRepository orderRepository;

    public Order getOrderById (String orderId){
            Order order = new Order(orderId);
            order.setCustomer(customerService.getCustomer(orderId));
            order.setProduct(productService.getProduct(orderId));
            return orderRepository.save(order);
        }

    public OrderRequest processOrder(OrderRequest payload) {
        return payload;
    }
}


