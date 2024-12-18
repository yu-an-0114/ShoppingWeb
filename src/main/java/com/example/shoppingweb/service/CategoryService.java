package com.example.shoppingweb.service;
import com.example.shoppingweb.repository.CartRepository;
import com.example.shoppingweb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository ;
}
