package com.example.service;

import com.example.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {


    public Customer getCustomer(String customerId) {

        Customer customer = new Customer();
        customer.setCId(customerId);
        customer.setCustomerName("huda");
        customer.setCustomerStreet("Street 1");
        customer.setCustomerZip("12345");
        customer.setCustomerCountry("Germany");

        return customer;

    }
}
