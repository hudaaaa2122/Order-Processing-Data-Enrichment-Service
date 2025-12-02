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
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
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
        Order order = new Order();
        order.setOrderId("21");
        order.setProductId("22");
        order.setCustomerId("29");
        order.setTimestamp("2025-11-14T23:49:00Z");

        Customer customer = new Customer();
        customer.setCId("29");
        customer.setCustomerName("huda");
        customer.setCustomerStreet("Street 1");
        customer.setCustomerZip("12345");
        customer.setCustomerCountry("Germany");

        when(customerService.getCustomer("29")).thenReturn(customer);

        Product product = new Product();
        product.setPId("22");
        product.setProductName("car");
        product.setProductPrice(100.0);
        product.setProductCategory("Category");
        product.setProductTags("Tag");

        when(productService.getProduct("22")).thenReturn(product);

        when(orderRepository.save(order)).thenAnswer(invocation -> invocation.getArgument(0));


        Order savedOrder = orderService.processOrder(order);
        assertNotNull(savedOrder);
        assertEquals("21", savedOrder.getOrderId());
        assertEquals("2025-11-14T23:49:00Z" , savedOrder.getTimestamp());
        assertEquals("huda", savedOrder.getCustomer().getCustomerName());
        assertEquals("car", savedOrder.getProduct().getProductName());
        assertEquals(100.0, savedOrder.getProduct().getProductPrice(), 0.001);
        assertEquals("Category", savedOrder.getProduct().getProductCategory());
        assertEquals("Tag", savedOrder.getProduct().getProductTags());
        assertEquals("Street 1", savedOrder.getCustomer().getCustomerStreet());
        assertEquals("12345", savedOrder.getCustomer().getCustomerZip());
        assertEquals("Germany", savedOrder.getCustomer().getCustomerCountry());
    }

    @Test
    void enrichOrder() {
        Order order = new Order();
        Customer customer = new Customer();
        Product product = new Product();
        orderService.enrichOrder(order, customer, product);
        assertNotNull(order.getCustomer());
        assertNotNull(order.getProduct());
        assertEquals(customer, order.getCustomer());
        assertEquals(product, order.getProduct());
    }

    @Test
    void getAllOrders() {
        Order order = new Order();
        order.setOrderId("1");

        Order order2 = new Order();
        order2.setOrderId("2");

        List<Order> mockList = List.of(order,order2);
        when(orderRepository.findAll((Specification<Order>) org.mockito.ArgumentMatchers.any()))
                .thenReturn(mockList);
        List<Order> orders = orderService.getAllOrders("29", "22");
        assertEquals(2,orders.size());
        assertEquals("1",orders.get(0).getOrderId());
        assertEquals("2",orders.get(1).getOrderId());
    }
}