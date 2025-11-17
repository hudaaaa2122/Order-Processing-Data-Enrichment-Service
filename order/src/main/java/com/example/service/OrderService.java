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
        Customer customer = customerService.getCustomer(order.getCustomerId());
        order.setCustomer(customer);
        Product product =productService.getProduct(order.getProductId());
        order.setProduct(product);

        return order;
        }

    public OrderRequest processOrder(OrderRequest payload) {
        Order order = new Order();
        order.setCustomerId(payload.getCustomerId());
        order.setProductId(payload.getProductId());
        order.setOrderId(payload.getOrderId());
        order.setTimestamp(payload.getTimestamp());
        orderRepository.save(order);
        return payload;
    }
}


