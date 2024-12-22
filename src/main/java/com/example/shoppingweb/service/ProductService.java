package com.example.shoppingweb.service;

import com.example.shoppingweb.model.Product;
import com.example.shoppingweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * 新增商品
     */
    public Product addProduct(Product product) {
        LocalDateTime now = LocalDateTime.now();
        product.setPublishDate(now);
        product.setModifiedDate(now);
        // You may also set default enabled = true if needed
        // product.setEnabled(true);

        return productRepository.save(product);
    }

    /**
     * 修改商品
     * @param id the ID of the product to update
     * @param updateProduct the product data used to update existing product
     */
    public Product updateProduct(Integer id, Product updateProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + id));
        LocalDateTime now = LocalDateTime.now();

        // Update fields if needed (example shown below)
        if (updateProduct.getProductName() != null
                && !updateProduct.getProductName().equals(existingProduct.getProductName())) {
            existingProduct.setProductName(updateProduct.getProductName());
        }
        if (updateProduct.getPrice() != null
                && !updateProduct.getPrice().equals(existingProduct.getPrice())) {
            existingProduct.setPrice(updateProduct.getPrice());
        }
        if (updateProduct.getStock() != null
                && !updateProduct.getStock().equals(existingProduct.getStock())) {
            existingProduct.setStock(updateProduct.getStock());
        }
        if (updateProduct.getReservedStock() != null
                && !updateProduct.getReservedStock().equals(existingProduct.getReservedStock())) {
            existingProduct.setReservedStock(updateProduct.getReservedStock());
        }
        if (updateProduct.getDescription() != null
                && !updateProduct.getDescription().equals(existingProduct.getDescription())) {
            existingProduct.setDescription(updateProduct.getDescription());
        }
        if (updateProduct.getImage() != null
                && !updateProduct.getImage().equals(existingProduct.getImage())) {
            existingProduct.setImage(updateProduct.getImage());
        }
        if (updateProduct.getCategory() != null
                && !updateProduct.getCategory().equals(existingProduct.getCategory())) {
            existingProduct.setCategory(updateProduct.getCategory());
        }
        if (updateProduct.isEnabled() != null
                && !updateProduct.isEnabled().equals(existingProduct.isEnabled())) {
            existingProduct.setEnabled(updateProduct.isEnabled());
        }

        // Update the modified date
        existingProduct.setModifiedDate(now);

        return productRepository.save(existingProduct);
    }

    /**
     * 刪除商品
     * @param id the ID of the product
     */
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + id));
        productRepository.delete(product);
    }

    /**
     * 搜尋商品 By ID
     * @param id the ID of the product
     */
    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + id));
    }

    public List<Product> getProductByName(String name) {
        List<Product> products = productRepository.findByProductName(name);
        if (products.isEmpty()) {
            throw new NoSuchElementException("Product not found with Name: " + name);
        }
        return products;
    }
}

