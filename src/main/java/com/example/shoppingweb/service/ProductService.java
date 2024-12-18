package com.example.shoppingweb.service;

import com.example.shoppingweb.model.Product;
import com.example.shoppingweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


}

