package com.example.shoppingweb.controller;

import com.example.shoppingweb.model.Coupon;
import com.example.shoppingweb.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping
    public ResponseEntity<Coupon> addCoupon(@RequestBody Coupon coupon) {
        Coupon savedCoupon = couponService.addCoupon(coupon);
        return ResponseEntity.ok(savedCoupon);
    }

    // 修改優惠券
    @PutMapping("/{id}")
    public ResponseEntity<Coupon> updateCoupon(@PathVariable Integer id, @RequestBody Coupon coupon) {
        try {
            Coupon updatedCoupon = couponService.updateCoupon(id, coupon);
            return ResponseEntity.ok(updatedCoupon);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // 刪除優惠券
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCoupon(@PathVariable Integer id) {
        try {
            couponService.deleteCoupon(id);
            return ResponseEntity.ok("Coupon deleted successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}