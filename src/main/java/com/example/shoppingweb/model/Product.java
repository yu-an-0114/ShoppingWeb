package com.example.shoppingweb.model;

import jakarta.persistence.Table;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // 商品id

    @Column(nullable = false)
    private String productName;  // 商品名稱

    @Column(nullable = false)
    private Integer price;  // 商品價錢

    @Column(nullable = false)
    private boolean soldOut;  // 庫存狀態 (0沒貨, 1有貨)

    private String description;  // 商品描述

    @Column(nullable = false)
    private Integer stock;  // 庫存數量

    private Integer reservedStock;  // 商品被預購數量

    @Column(nullable = false)
    private Integer sales;  // 賣出數量

    @Column(nullable = false)
    private LocalDateTime publishDate;  // 創造日期

    private LocalDateTime modifiedDate;  // 商品修改日期

    @Column(nullable = false)
    private String image;  // 圖片

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;  // 商品分類

    @Column(nullable = false)
    private Boolean enabled;  // 商品狀態 (0下架, 1上架)

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getReservedStock() {
        return reservedStock;
    }

    public void setReservedStock(Integer reservedStock) {
        this.reservedStock = reservedStock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
