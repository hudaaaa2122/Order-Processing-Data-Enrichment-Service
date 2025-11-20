package com.example.service;

import com.example.dto.OrderDetails;
import com.example.dto.OrderResponse;
import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.dto.OrderRequest;
import com.example.entity.Product;
import com.example.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class OrderService {
    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderRepository orderRepository;

    public OrderDetails getOrderById (String orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

        OrderDetails response = new OrderDetails();
        BeanUtils.copyProperties(order , response);
        return response;
//        response.setOrderId(order.getOrderId());
//        response.setTimestamp(order.getTimestamp());
//
//        response.setCustomerId(order.getCustomerId());
//        response.setCustomerName(order.getCustomerName());
//        response.setCustomerStreet(order.getCustomerStreet());
//        response.setCustomerZip(order.getCustomerZip());
//        response.setCustomerCountry(order.getCustomerCountry());
//
//        response.setProductId(order.getProductId());
//        response.setProductName(order.getProductName());
//        response.setProductPrice(order.getProductPrice());
//        response.setProductCategory(order.getProductCategory());
//        response.setProductTags(order.getProductTags());
        }

    public OrderDetails processOrder(OrderDetails payload) {
        Order order = new Order();
        BeanUtils.copyProperties(payload , order);
        orderRepository.save(order);
        OrderDetails response = new OrderDetails();
        BeanUtils.copyProperties(order , response);
        return response;
//        order.setOrderId(payload.getOrderId());
//        order.setTimestamp(payload.getTimestamp());
//
//        order.setCustomerId(payload.getCustomerId());
//        order.setCustomerName(payload.getCustomerName());
//        order.setCustomerStreet(payload.getCustomerStreet());
//        order.setCustomerZip(payload.getCustomerZip());
//        order.setCustomerCountry(payload.getCustomerCountry());
//
//        order.setProductId(payload.getProductId());
//        order.setProductName(payload.getProductName());
//        order.setProductPrice(payload.getProductPrice());
//        order.setProductCategory(payload.getProductCategory());
//        order.setProductTags(payload.getProductTags());


//        response.setOrderId(payload.getOrderId());
//        response.setTimestamp(payload.getTimestamp());
//
//        response.setCustomerId(payload.getCustomerId());
//        response.setCustomerZip(payload.getCustomerZip());
//        response.setCustomerCountry(payload.getCustomerCountry());
//        response.setCustomerStreet(payload.getCustomerStreet());
//        response.setCustomerName(payload.getCustomerName());
//
//
//        response.setProductName(payload.getProductName());
//        response.setProductPrice(payload.getProductPrice());
//        response.setProductCategory(payload.getProductCategory());
//        response.setProductTags(payload.getProductTags());
//        response.setProductId(payload.getProductId());

    }
}


