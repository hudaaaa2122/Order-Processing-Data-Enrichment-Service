package com.example.service;

import com.example.dto.OrderRequest;
import com.example.dto.OrderResponse;
import com.example.entity.Customer;
import com.example.entity.Order;
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

    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
    public Order processOrder(Order order) {

        Customer customer = customerService.getCustomer(order.getCustomerId());
        Product product = productService.getProduct(order.getProductId());
        enrichOrder(order, customer, product);
        return orderRepository.save(order);
    }
    public Order toOrder(OrderRequest payload) {
        Order order = new Order();
        order.setOrderId(payload.getOrderId());
        order.setTimestamp(payload.getTimestamp());
        return order;
    }
    public void enrichOrder(Order order, Customer customer, Product product) {
        order.setCustomer(customer);
        order.setProduct(product);
    }
}

