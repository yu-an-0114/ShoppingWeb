package com.example.shoppingweb.controller;

import com.example.shoppingweb.model.Product;
import com.example.shoppingweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 新增商品
     * POST /products
     */
    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        try {
            Product createdProduct = productService.addProduct(product);
            return ResponseEntity.ok(createdProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while creating the product: " + e.getMessage());
        }
    }

    /**
     * 修改商品
     * PUT /products/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id,
                                                @RequestBody Product product) {
        try {
            Product updatedProduct = productService.updateProduct(id, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating the product: " + e.getMessage());
        }
    }

    /**
     * 刪除商品
     * DELETE /products/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Product with ID " + id + " has been deleted successfully.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting the product: " + e.getMessage());
        }
    }

    /**
     * 搜尋商品 by ID
     * GET /products/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Integer id) {
        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving the product: " + e.getMessage());
        }
    }

    /**
     * 搜尋商品 by productName (optional feature)
     * GET /products/search?name=xxx
     */
    @GetMapping("/search")
    public ResponseEntity<Object> getProductByName(@RequestParam("name") String productName) {
        try {
            List<Product> products = productService.getProductByName(productName);
            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No products found with name containing: " + productName);
            }
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while searching for products: " + e.getMessage());
        }
    }
}
