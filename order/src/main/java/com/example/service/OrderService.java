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
        if (customer != null) {
            order.setCustomerName(customer.getName());
            order.setCustomerStreet(customer.getStreet());
            order.setCustomerZip(customer.getZip());
            order.setCustomerCountry(customer.getCountry());
        }
        Product product =productService.getProduct(order.getProductId());
        if (product != null) {
            order.setProductName(product.getName());
            order.setProductPrice(product.getPrice());
            order.setProductCategory(product.getCategory());
            order.setProductTags(product.getTags());
        }
        return order;
        }

    public OrderRequest processOrder(Order payload) {
        Order order = new Order();
        order.setOrderId(payload.getOrderId());
        Order  saveOrder = orderRepository.save(order);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderId(saveOrder.getOrderId());
        orderRequest.setCustomerId(saveOrder.getCustomerId());
        orderRequest.setProductId(saveOrder.getProductId());
        orderRequest.setTimestamp(saveOrder.getTimestamp());

        return orderRequest;
    }
}


