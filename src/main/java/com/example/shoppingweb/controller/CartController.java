
package com.example.shoppingweb.controller;

import com.example.shoppingweb.model.Cart;
import com.example.shoppingweb.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody Map<String, Object> request) {
        Integer productId = (Integer) request.get("productId");
        Integer quantity = (Integer) request.get("quantity");
        Integer userId = (Integer) request.get("userId");
        System.out.println("Received request: productId=" + productId + ", quantity=" + quantity + ", userId=" + userId);

        try {
            cartService.addToCart(productId, userId, quantity);
            return ResponseEntity.ok("Product added to cart successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCart(@RequestBody Map<String, Object> request) {
        Integer productId = (Integer) request.get("productId");
        Integer userId = (Integer) request.get("userId");
        Integer quantity = (Integer) request.get("quantity");
        System.out.println("Updating cart: productId=" + productId + ", userId=" + userId + ", quantity=" + quantity);

        try {
            cartService.updateCart(userId, productId, quantity);
            return ResponseEntity.ok("Cart updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
