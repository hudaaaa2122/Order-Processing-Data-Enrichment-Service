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
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        if (order == null) {return null;}
        Customer Customer = customerService.getCustomer(order.getCustomerId());
        Product Product = productService.getProduct(order.getProductId());
        order.setCustomer(Customer);
        order.setProduct(Product);
        order.setTimestamp(order.getTimestamp());
        return order;
        }

    public Order processOrder(OrderRequest payload) {
        Order order = new Order(payload.getOrderId());
        order.setCustomerId(payload.getCustomerId());
        order.setProductId(payload.getProductId());
        order.setTimestamp(payload.getTimestamp());
        return orderRepository.save(order);
    }
}


