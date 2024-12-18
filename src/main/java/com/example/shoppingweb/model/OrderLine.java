package com.example.shoppingweb.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ORDER_LINE")
@IdClass(OrderLine.OrderLineId.class)
public class OrderLine {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

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


    public static class OrderLineId implements Serializable {

        private Integer order;
        private Integer product;


        public OrderLineId() {}


        public OrderLineId(Integer order, Integer product) {
            this.order = order;
            this.product = product;
        }


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
