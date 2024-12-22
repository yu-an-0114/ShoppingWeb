package com.example.shoppingweb.service;
import com.example.shoppingweb.DTO.CategoryDTO;
import com.example.shoppingweb.model.Category;
import com.example.shoppingweb.model.Product;
import com.example.shoppingweb.repository.CartRepository;
import com.example.shoppingweb.repository.CategoryRepository;
import com.example.shoppingweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO getCategoryWithProducts(Integer categoryId, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findByCategoryCategoryId(categoryId, pageable);


        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("Category not found with ID: " + categoryId));

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setCategoryDiscount(category.getCategoryDiscount());

        List<CategoryDTO.ProductSummaryDTO> productSummaries = productPage.getContent().stream()
                .map(product -> {
                    CategoryDTO.ProductSummaryDTO productSummary = new CategoryDTO.ProductSummaryDTO();
                    productSummary.setId(product.getId());
                    productSummary.setProductName(product.getProductName());
                    productSummary.setImage(product.getImage());
                    productSummary.setPrice(product.getPrice());
                    return productSummary;
                })
                .collect(Collectors.toList());

        categoryDTO.setProducts(productSummaries);
        return categoryDTO;
    }
}
