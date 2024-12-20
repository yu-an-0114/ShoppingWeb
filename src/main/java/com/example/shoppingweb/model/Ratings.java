package com.example.shoppingweb.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating")
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "rating_score", nullable = false)
    private Integer ratingScore;

    @Column(name = "rating_comment")
    private String ratingComment;

    @Column(name = "rating_date", nullable = false)
    private LocalDateTime ratingDate;

    // Getters 和 Setters
    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(Integer ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getRatingComment() {
        return ratingComment;
    }

    public void setRatingComment(String ratingComment) {
        this.ratingComment = ratingComment;
    }

    public LocalDateTime getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(LocalDateTime ratingDate) {
        this.ratingDate = ratingDate;
    }
}
