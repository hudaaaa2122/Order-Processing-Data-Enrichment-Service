package com.example.service;

import com.example.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product getProduct(String productId){
         return new Product( "car" , 12345 , "carr" , "23tag");
    }

}
