package com.example.shoppingweb.controller;

import com.example.shoppingweb.model.OrderLine;
import com.example.shoppingweb.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderlines")
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

 

}
