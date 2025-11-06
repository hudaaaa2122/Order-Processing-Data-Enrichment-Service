package com.example.service;

import com.example.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    public Customer getCustomer(String customerId){
        Customer customer1=new Customer("huda" , "farooq colony street no 10" , "6350" , "pakistan");
        return customer1;
    }
}
