package com.example.shoppingweb.controller;

import com.example.shoppingweb.model.Order;
import com.example.shoppingweb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("/add")
    public ResponseEntity<String> createOrder(@RequestBody com.example.shoppingweb.dto.OrderWithLinesRequest request) {
        try {
            orderService.createOrder(request.getOrder(), request.getOrderLines());
            return ResponseEntity.ok("Order and OrderLines created successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating order: " + e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateOrder(@RequestParam Integer orderId, @RequestBody com.example.shoppingweb.dto.OrderWithLinesRequest request) {
        try {
            orderService.updateOrder(orderId, request.getOrder(), request.getOrderLines());
            return ResponseEntity.ok("Order and OrderLines updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating order: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOrder(@RequestParam Integer orderId) {
        try {
            orderService.deleteOrder(orderId);
            return ResponseEntity.ok("Order deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting order: " + e.getMessage());
        }
    }
    @GetMapping("/user")
    public ResponseEntity<?> getOrdersByUserId(@RequestParam Integer userId) {
        try {
            List<Order> orders = orderService.getOrdersByUserId(userId);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching orders: " + e.getMessage());
        }
    }
}
