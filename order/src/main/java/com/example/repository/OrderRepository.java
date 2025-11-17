package com.example.repository;

import com.example.entity.Order;
import com.example.entity.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
