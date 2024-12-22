package com.example.shoppingweb.repository;

import com.example.shoppingweb.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductName(String productName);
    List<Product> findByProductNameContainingIgnoreCase(String productName);
    Page<Product> findByCategoryCategoryId(Integer categoryId, Pageable pageable);

}
