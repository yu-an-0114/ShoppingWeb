package com.example.shoppingweb.service;

import com.example.shoppingweb.model.Coupon;
import com.example.shoppingweb.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public Coupon addCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public Coupon updateCoupon(Integer id, Coupon updatedCoupon) {
        Optional<Coupon> existingCoupon = couponRepository.findById(id);
        if (existingCoupon.isPresent()) {
            Coupon coupon = existingCoupon.get();
            coupon.setStartDate(updatedCoupon.getStartDate());
            coupon.setEndDate(updatedCoupon.getEndDate());
            coupon.setDiscount(updatedCoupon.getDiscount());
            coupon.setCategory(updatedCoupon.getCategory());
            coupon.setLowLimit(updatedCoupon.getLowLimit());
            return couponRepository.save(coupon);
        } else {
            throw new IllegalArgumentException("Coupon not found with ID: " + id);
        }
    }

    public void deleteCoupon(Integer id) {
        if (couponRepository.existsById(id)) {
            couponRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Coupon not found with ID: " + id);
        }
    }
}