package com.example.shoppingweb.service;

import com.example.shoppingweb.model.Cart;
import com.example.shoppingweb.model.Product;
import com.example.shoppingweb.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.shoppingweb.model.Member;
import com.example.shoppingweb.repository.MemberRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

}
