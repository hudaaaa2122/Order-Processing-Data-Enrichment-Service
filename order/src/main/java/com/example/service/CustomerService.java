package com.example.service;

import com.example.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {


    public Customer getCustomer(String customerId) {

        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName("huda");
        customer.setStreet("Street 1");
        customer.setZip("12345");
        customer.setCountry("Germany");

        return customer;

    }
}
