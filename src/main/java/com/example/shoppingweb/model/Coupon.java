package com.example.shoppingweb.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COUPON")
public class Coupon {

    @Id
    @Column(nullable = false)
    private String id; // 優惠券ID

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member; // 發放優惠券的會員

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate; // 開始日期

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate; // 結束日期

    @Column(nullable = false)
    private Double discount; // 折扣數

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; // 適用商品分類（可選）

    @Column(name = "low_limit")
    private Integer lowLimit; // 金額下限（可選）

    // Getters 和 Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(Integer lowLimit) {
        this.lowLimit = lowLimit;
    }
}
