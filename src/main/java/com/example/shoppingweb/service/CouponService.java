package com.example.shoppingweb.service;

import com.example.shoppingweb.model.Category;
import com.example.shoppingweb.model.Coupon;
import com.example.shoppingweb.repository.CategoryRepository;
import com.example.shoppingweb.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Coupon addCoupon(Coupon coupon) {
        if (coupon.getCategory() != null && coupon.getCategory().getCategoryId() != null) {
            Category category = categoryRepository.findById(coupon.getCategory().getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Category with ID " + coupon.getCategory().getCategoryId() + " does not exist."));
            coupon.setCategory(category);
        }
        return couponRepository.save(coupon);
    }
    public Coupon updateCoupon(Integer id, Coupon updatedCoupon) {
        Coupon existingCoupon = couponRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Coupon not found with ID: " + id));

        if (updatedCoupon.getStartDate() != null) {
            existingCoupon.setStartDate(updatedCoupon.getStartDate());
        }
        if (updatedCoupon.getEndDate() != null) {
            if (updatedCoupon.getEndDate().isBefore(existingCoupon.getStartDate())) {
                throw new IllegalArgumentException("End date must be after start date.");
            }
            existingCoupon.setEndDate(updatedCoupon.getEndDate());
        }
        if (updatedCoupon.getDiscount() != null) {
            existingCoupon.setDiscount(updatedCoupon.getDiscount());
        }
        if (updatedCoupon.getLowLimit() != null) {
            existingCoupon.setLowLimit(updatedCoupon.getLowLimit());
        }
        if (updatedCoupon.getCategory() != null && updatedCoupon.getCategory().getCategoryId() != null) {

            Category category = categoryRepository.findById(updatedCoupon.getCategory().getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + updatedCoupon.getCategory().getCategoryId()));
            existingCoupon.setCategory(category);
        }
        return couponRepository.save(existingCoupon);
    }
    public void deleteCoupon(Integer id) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Coupon not found with ID: " + id));

        couponRepository.delete(coupon);
    }
}