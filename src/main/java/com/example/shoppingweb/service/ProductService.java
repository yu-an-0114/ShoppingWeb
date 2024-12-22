package com.example.shoppingweb.service;
import com.example.shoppingweb.DTO.ProductDTO;
import com.example.shoppingweb.model.Category;
import com.example.shoppingweb.model.Product;
import com.example.shoppingweb.repository.CategoryRepository;
import com.example.shoppingweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    public ProductDTO toProductDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setStock(product.getStock());
        dto.setImage(product.getImage());


        return dto;
    }

    public Product addProduct(Product product) {
        if (product.getCategory() == null || product.getCategory().getCategoryId() == null) {
            throw new RuntimeException("Category ID is required.");
        }
        Category existingCategory = categoryRepository.findById(product.getCategory().getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + product.getCategory().getCategoryId()));
        product.setCategory(existingCategory);
        LocalDateTime now = LocalDateTime.now();
        product.setPublishDate(now);
        product.setModifiedDate(now);
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product updateProduct) {
        if (id == null) {
            throw new IllegalArgumentException("Product ID must not be null.");
        }
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + id));
        LocalDateTime now = LocalDateTime.now();
        if (updateProduct.getProductName() != null) {
            existingProduct.setProductName(updateProduct.getProductName());
        }
        if (updateProduct.getPrice() != null) {
            existingProduct.setPrice(updateProduct.getPrice());
        }
        if (updateProduct.getStock() != null) {
            existingProduct.setStock(updateProduct.getStock());
        }
        if (updateProduct.getDescription() != null) {
            existingProduct.setDescription(updateProduct.getDescription());
        }
        if (updateProduct.getImage() != null) {
            existingProduct.setImage(updateProduct.getImage());
        }
        if (updateProduct.getCategory() != null) {
            if (updateProduct.getCategory().getCategoryId() == null) {
                throw new IllegalArgumentException("Category ID must not be null.");
            }
            Category category = categoryRepository.findById(updateProduct.getCategory().getCategoryId())
                    .orElseThrow(() -> new NoSuchElementException("Category not found with ID: " + updateProduct.getCategory().getCategoryId()));
            existingProduct.setCategory(category);
        }

        if (updateProduct.isEnabled() != null) {
            existingProduct.setEnabled(updateProduct.isEnabled());
        }

        // 更新修改時間
        existingProduct.setModifiedDate(now);

        // 保存更新後的商品
        return productRepository.save(existingProduct);
    }
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + id));
        productRepository.delete(product);
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + id));
    }

    public List<ProductDTO> getProductDTOByName(String productName) {
        List<Product> products = productRepository.findByProductNameContainingIgnoreCase(productName);

        return products.stream()
                .map(this::toProductDTO)
                .collect(Collectors.toList());
    }

}

