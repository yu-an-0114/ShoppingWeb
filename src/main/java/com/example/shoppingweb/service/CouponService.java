package com.example.shoppingweb.service;

import com.example.shoppingweb.model.Coupon;
import com.example.shoppingweb.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;


}
