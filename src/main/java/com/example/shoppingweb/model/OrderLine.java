package com.example.shoppingweb.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ORDER_LINE")
@IdClass(OrderLine.OrderLineId.class) // 使用内部静态类作为复合主键
public class OrderLine {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // 订单

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; // 商品

    @Column(nullable = false)
    private Integer quantity; // 商品数量

    @Column
    private String note; // 商品备注

    // Getters 和 Setters
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // 内部静态类，用于定义复合主键
    public static class OrderLineId implements Serializable {

        private Integer order; // 对应 Order 的主键
        private Integer product; // 对应 Product 的主键

        // 默认构造函数
        public OrderLineId() {}

        // 参数化构造函数
        public OrderLineId(Integer order, Integer product) {
            this.order = order;
            this.product = product;
        }

        // Getters 和 Setters
        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }

        public Integer getProduct() {
            return product;
        }

        public void setProduct(Integer product) {
            this.product = product;
        }

        // 重写 equals 和 hashCode
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OrderLineId that = (OrderLineId) o;
            return Objects.equals(order, that.order) &&
                    Objects.equals(product, that.product);
        }

        @Override
        public int hashCode() {
            return Objects.hash(order, product);
        }
    }
}
