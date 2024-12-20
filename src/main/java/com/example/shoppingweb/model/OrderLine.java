package com.example.shoppingweb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orderLine")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderLineId;  // 訂單商品id

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;  // 訂單編號

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;  // 商品編號

    @Column(nullable = false)
    private int quantity;  // 商品數量

    private String note;  // 訂購的商品備註

    // Getters and Setters
    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
