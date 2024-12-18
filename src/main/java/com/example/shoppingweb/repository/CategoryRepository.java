package com.example.shoppingweb.repository;

import com.example.shoppingweb.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Cart, Long> {
}
