package com.example.shoppingweb.service;

import com.example.shoppingweb.model.Cart;
import com.example.shoppingweb.model.Product;
import com.example.shoppingweb.repository.CartRepository;
import com.example.shoppingweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.shoppingweb.model.Member;
import com.example.shoppingweb.repository.MemberRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MemberRepository memberRepository;

    public void addToCart(Integer productId, Integer userId, Integer quantity) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found."));

        Member user = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));

        Cart existingCart = cartRepository.findByProductIdAndUserId(productId, userId);

        if (existingCart != null) {
            existingCart.setQuantity(existingCart.getQuantity() + quantity);
            cartRepository.save(existingCart);
        } else {
            Cart newCart = new Cart();
            newCart.setProduct(product);
            newCart.setUser(user);
            newCart.setQuantity(quantity);
            cartRepository.save(newCart);
        }
    }
    public void updateCart(Integer userId, Integer productId, Integer quantity) {
        Cart existingCart = cartRepository.findByProductIdAndUserId(productId, userId);
        if (existingCart == null) {
            throw new IllegalArgumentException("Cart item not found.");
        }
        if (quantity <= 0) {
            cartRepository.delete(existingCart);
        } else {
            existingCart.setQuantity(quantity);
            cartRepository.save(existingCart);
        }
    }
}
