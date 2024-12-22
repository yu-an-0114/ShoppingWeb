package com.example.shoppingweb.repository;

import com.example.shoppingweb.model.Cart;
import com.example.shoppingweb.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
