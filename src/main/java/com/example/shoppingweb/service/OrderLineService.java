package com.example.shoppingweb.service;

import com.example.shoppingweb.model.OrderLine;
import com.example.shoppingweb.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {

    @Autowired
    private OrderLineRepository orderLineRepository;
}
