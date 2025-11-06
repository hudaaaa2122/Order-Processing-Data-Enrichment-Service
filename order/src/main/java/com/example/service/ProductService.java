package com.example.service;

import com.example.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product getProduct(String productId){
        Product product1 = new Product("product1" , 100.0 , "food" , "tags");
        return product1;
    }

}
