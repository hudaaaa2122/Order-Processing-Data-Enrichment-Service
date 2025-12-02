package com.example.service;

import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.entity.Product;
import com.example.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private CustomerService customerService;
    @Mock
    private ProductService productService;
    @InjectMocks
    private OrderService orderService;

    @Test
    void getOrderById() {
         //Arrange
        Order order = new Order();
        order.setOrderId("21");

        Customer customer = new Customer();
        customer.setCustomerName("huda");

        Product product = new Product();
        product.setProductName("car");
        order.setProduct(product);
        order.setCustomer(customer);

        when(orderRepository.findById("21")).thenReturn(Optional.of(order));
        // Act
        Order orderResponse = orderService.getOrderById("21");
        // Assert
        assertNotNull(orderResponse);
        assertEquals("21", orderResponse.getOrderId());
        assertEquals("huda", customer.getCustomerName());
        assertEquals("car", product.getProductName());

    }

    @Test
    void processOrder() {
    }

    @Test
    void enrichOrder() {
    }

    @Test
    void getAllOrders() {
    }
}