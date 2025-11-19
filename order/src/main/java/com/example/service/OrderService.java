package com.example.service;

import com.example.dto.OrderDetails;
import com.example.dto.OrderResponse;
import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.dto.OrderRequest;
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

    public OrderDetails getOrderById (String orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

        Product product =productService.getProduct(order.getProductId());
        Customer customer = customerService.getCustomer(order.getCustomerId());

        OrderDetails response = new OrderDetails();
        response.setOrderId(order.getOrderId());
        response.setTimestamp(order.getTimestamp());

        response.setCustomerId(order.getCustomerId());
        response.setCustomerName(customer.getName());
        response.setCustomerStreet(customer.getStreet());
        response.setCustomerZip(customer.getZip());
        response.setCustomerCountry(customer.getCountry());

        response.setProductId(order.getProductId());
        response.setProductName(product.getName());
        response.setProductPrice(product.getPrice());
        response.setProductCategory(product.getCategory());
        response.setProductTags(product.getTags());

        return response;
        }

    public OrderResponse processOrder(OrderRequest payload) {
        Order order = new Order();
        order.setOrderId(payload.getOrderId());
        order.setCustomerId(payload.getCustomerId());
        order.setProductId(payload.getProductId());
        order.setTimestamp(payload.getTimestamp());
        orderRepository.save(order);

        OrderResponse response = new OrderResponse();
        response.setOrderId(payload.getOrderId());
        response.setTimestamp(order.getTimestamp());
        response.setCustomerId(order.getCustomerId());
        response.setProductId(order.getProductId());

        return response;
    }
}


