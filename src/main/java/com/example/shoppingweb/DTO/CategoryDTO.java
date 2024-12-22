package com.example.shoppingweb.DTO;

import java.util.List;

public class CategoryDTO {
    private Integer categoryId;
    private String categoryName;
    private Double categoryDiscount;
    private List<ProductSummaryDTO> products;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getCategoryDiscount() {
        return categoryDiscount;
    }

    public void setCategoryDiscount(Double categoryDiscount) {
        this.categoryDiscount = categoryDiscount;
    }

    public List<ProductSummaryDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSummaryDTO> products) {
        this.products = products;
    }

    // Inner class for product summary
    public static class ProductSummaryDTO {
        private Integer id;
        private String productName;
        private String image;
        private Integer price;

        // Getters and Setters
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }
    }
}