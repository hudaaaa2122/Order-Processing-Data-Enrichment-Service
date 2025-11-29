package com.example.service;

import com.example.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    public Product getProduct(String productId) {

        Product product = new Product();
        product.setPId(productId);
        product.setProductName("Product ");
        product.setProductPrice(100.0);
        product.setProductCategory("Category ");
        product.setProductTags("Tag ");
        return product;
    }

}
