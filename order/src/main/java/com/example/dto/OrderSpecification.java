package com.example.dto;

import com.example.entity.Order;
import org.springframework.data.jpa.domain.Specification;

public class OrderSpecification {

    public static Specification<Order> customerById(String customerId) {
        return (root, query, cb) ->  cb.equal(root.get("customer").get("cId"), customerId);
    }
    public static Specification<Order> productById(String productId) {
        return (root, query, cb) ->  cb.equal(root.get("product").get("pId"), productId);
    }
}
