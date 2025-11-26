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

    public OrderResponse getOrderById(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return toResponse(order);
    }

    public OrderResponse processOrder(OrderRequest payload) {

        Order order = new Order();
        Customer customer = customerService.getCustomer(payload.getCustomerId());
        Product product = productService.getProduct(payload.getProductId());

        order.setOrderId(payload.getOrderId());
        order.setTimestamp(payload.getTimestamp());

        order.setProductId(payload.getProductId());
        order.setCustomerId(payload.getCustomerId());
        order.setCustomerZip(customer.getZip());
        order.setCustomerCountry(customer.getCountry());
        order.setCustomerStreet(customer.getStreet());
        order.setCustomerName(customer.getName());


        order.setProductName(product.getName());
        order.setProductPrice(product.getPrice());
        order.setProductCategory(product.getCategory());
        order.setProductTags(product.getTags());

        Order savedOrder = orderRepository.save(order);

        return toResponse(savedOrder);

    }

    public OrderResponse  toResponse(Order order) {
        OrderResponse response = new OrderResponse();

        response.setOrderId(order.getOrderId());
        response.setTimestamp(order.getTimestamp());

        response.setCustomerId(order.getCustomerId());
        response.setCustomerName(order.getCustomerName());
        response.setCustomerStreet(order.getCustomerStreet());
        response.setCustomerZip(order.getCustomerZip());
        response.setCustomerCountry(order.getCustomerCountry());

        response.setProductId(order.getProductId());
        response.setProductName(order.getProductName());
        response.setProductPrice(order.getProductPrice());
        response.setProductCategory(order.getProductCategory());
        response.setProductTags(order.getProductTags());

        return response;
    }
}


