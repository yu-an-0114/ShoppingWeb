package com.example.shoppingweb.repository;

import com.example.shoppingweb.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByMemberId(Integer memberId);
}
