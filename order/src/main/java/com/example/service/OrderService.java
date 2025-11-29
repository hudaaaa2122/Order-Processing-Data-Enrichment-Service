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

    public OrderResponse processOrder( OrderRequest payload) {
        Order order = toOrder(payload);
        Customer customer = customerService.getCustomer(payload.getCustomerId());
        Product product = productService.getProduct(payload.getProductId());
        enrichOrder(order , customer , product);
        Order savedOrder = orderRepository.save(order);
        return toResponse(savedOrder);
    }


    public Order toOrder (OrderRequest payload ){

        Order order = new Order();

        order.setOrderId(payload.getOrderId());
        order.setTimestamp(payload.getTimestamp());
        return order;
    }
    public void enrichOrder(Order order , Customer customer , Product product){
        order.setCustomer(customer);
        order.setProduct(product);

    }

    public OrderResponse  toResponse(Order order) {
        OrderResponse response = new OrderResponse();

        response.setOrderId(order.getOrderId());
        response.setTimestamp(order.getTimestamp());

        if (order.getCustomer() != null) {
            response.setCustomerId(order.getCustomer().getCId());
            response.setCustomerName(order.getCustomer().getCustomerName());
            response.setCustomerStreet(order.getCustomer().getCustomerStreet());
            response.setCustomerZip(order.getCustomer().getCustomerZip());
            response.setCustomerCountry(order.getCustomer().getCustomerCountry());
        }
        if (order.getProduct() != null) {
            response.setProductId(order.getProduct().getPId());
            response.setProductName(order.getProduct().getProductName());
            response.setProductPrice(order.getProduct().getProductPrice());
            response.setProductCategory(order.getProduct().getProductCategory());
            response.setProductTags(order.getProduct().getProductTags());
        }

        return response;
    }
}


