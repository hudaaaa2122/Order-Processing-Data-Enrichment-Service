package com.example;


import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.entity.Product;
import com.example.repository.OrderRepository;
import com.example.service.CustomerService;
import com.example.service.OrderService;
import com.example.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock private OrderRepository orderRepository;
    @Mock private CustomerService customerService;
    @Mock private ProductService productService;
    @InjectMocks
    private OrderService orderService;
//
//    @Test
////    public void testOrderService(){
////       when(customerService.getCustomer(any()))
////               .thenReturn(new Customer("huda", "farooq colony street no 10", "6350", "pakistan"));
////       when(productService.getProduct(any()))
////               .thenReturn(new Product("car" , 12345 , "carr" , "23tag"));
////       when(orderRepository.save(any()))
////       .thenAnswer(invocation -> invocation.getArgument(0));
////       Order order = orderService.getOrderById("123");
////       assertNotNull(order.getCustomer());
////       assertNotNull(order.getProduct());
////       assertEquals("huda" , order.getCustomer().getName());
////       assertEquals("car" , order.getProduct().getName());
////       verify(orderRepository).save(any(Order.class));
////    }
    }

