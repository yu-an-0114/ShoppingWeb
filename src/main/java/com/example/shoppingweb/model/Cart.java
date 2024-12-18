package com.example.shoppingweb.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartId;  // 新增 cart_id 作為主鍵

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;  // 外鍵，指向 Product 表

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Member user;  // 外鍵，指向 Member 表

    @Column(nullable = false)
    private Integer quantity;  // 商品數量

    // Getters 和 Setters
    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getUser() {
        return user;
    }

    public void setUser(Member user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
