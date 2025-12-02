package com.example.service;


import com.example.dto.OrderSpecification;
import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.entity.Product;
import com.example.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Order> getAllOrders(String customerId, String productId) {
        Specification<Order> spec = (root, query, cb) -> cb.conjunction();
        if (customerId != null && !customerId.isEmpty()){ spec = spec.and(OrderSpecification.customerById(customerId));}
        if (productId != null && !productId.isEmpty()) {spec = spec.and(OrderSpecification.productById(productId));}
        return orderRepository.findAll(spec);
    }

    public void enrichOrder(Order order, Customer customer, Product product) {
        order.setCustomer(customer);
        order.setProduct(product);
    }
}
