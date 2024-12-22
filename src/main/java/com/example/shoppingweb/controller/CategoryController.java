package com.example.shoppingweb.controller;

import com.example.shoppingweb.DTO.CategoryDTO;
import com.example.shoppingweb.model.Product;
import com.example.shoppingweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategoryWithProducts(
            @PathVariable Integer categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        CategoryDTO categoryDTO = categoryService.getCategoryWithProducts(categoryId, page, size);
        return ResponseEntity.ok(categoryDTO);
    }
}
