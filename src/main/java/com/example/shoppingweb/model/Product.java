package com.example.shoppingweb.model;

import jakarta.persistence.Table;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // 商品id

    @Column(nullable = false)
    private String productName;  // 商品名稱

    @Column(nullable = false)
    private int price;  // 商品價錢

    @Column(nullable = false)
    private boolean soldOut;  // 庫存狀態 (0沒貨, 1有貨)

    private String description;  // 商品描述

    @Column(nullable = false)
    private int stock;  // 庫存數量

    private int reservedStock;  // 商品被預購數量

    @Column(nullable = false)
    private int sales;  // 賣出數量

    @Column(nullable = false)
    private Date publishDate;  // 創造日期

    private Date modifiedDate;  // 商品修改日期

    @Column(nullable = false)
    private String image;  // 圖片

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;  // 商品分類

    @Column(nullable = false)
    private boolean enabled;  // 商品狀態 (0下架, 1上架)

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getReservedStock() {
        return reservedStock;
    }

    public void setReservedStock(int reservedStock) {
        this.reservedStock = reservedStock;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
