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
    public ResponseEntity<?> addCoupon(@RequestBody Coupon coupon) {
        try {
            Coupon savedCoupon = couponService.addCoupon(coupon);
            return ResponseEntity.ok(savedCoupon);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCoupon(@PathVariable Integer id, @RequestBody Coupon coupon) {
        try {
            Coupon updatedCoupon = couponService.updateCoupon(id, coupon);
            return ResponseEntity.ok(updatedCoupon);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCoupon(@PathVariable Integer id) {
        try {
            couponService.deleteCoupon(id);
            return ResponseEntity.ok("Coupon deleted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }

}