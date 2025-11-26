package com.example.service;

import com.example.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    public Product getProduct(String productId) {
        Product product = new Product();
        product.setId(productId);
        product.setName("Product ");
        product.setPrice(100.0);
        product.setCategory("Category ");
        product.setTags("Tag ");
        return product;
    }

}
