package com.example.shoppingweb.service;

import com.example.shoppingweb.model.Order;
import com.example.shoppingweb.model.OrderLine;
import com.example.shoppingweb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderLineService orderLineService;
    public void createOrder(Order order, List<OrderLine> orderLines) {
        if (order.getMember() == null || order.getAddress() == null) {
            throw new IllegalArgumentException("Member and Address are required fields.");
        }

        order.setOrderDate(LocalDateTime.now());
        order.setDeliveryDate(LocalDateTime.now().plusDays(3));

        Order savedOrder = orderRepository.save(order);
        for (OrderLine line : orderLines) {
            line.setOrder(savedOrder);
        }
        orderLineService.saveAll(orderLines);
    }
    public void updateOrder(Integer orderId, Order updatedOrder, List<OrderLine> updatedOrderLines) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found."));

        if (updatedOrder.getAddress() != null) {
            existingOrder.setAddress(updatedOrder.getAddress());
        }
        if (updatedOrder.getPaymentMethod() != null) {
            existingOrder.setPaymentMethod(updatedOrder.getPaymentMethod());
        }
        if (updatedOrder.getOrderStatus() != null) {
            existingOrder.setOrderStatus(updatedOrder.getOrderStatus());
        }
        orderRepository.save(existingOrder);
        List<OrderLine> existingOrderLines = orderLineService.findByOrderId(orderId);
        List<OrderLine> toDelete = existingOrderLines.stream()
                .filter(line -> updatedOrderLines.stream()
                        .noneMatch(updatedLine -> updatedLine.getOrderLineId() == line.getOrderLineId()))
                .toList();
        orderLineService.deleteAll(toDelete);

        for (OrderLine updatedLine : updatedOrderLines) {
            updatedLine.setOrder(existingOrder);
            orderLineService.save(updatedLine);
        }
    }
    public void deleteOrder(Integer orderId) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found."));

        List<OrderLine> orderLines = orderLineService.findByOrderId(orderId);
        if (!orderLines.isEmpty()) {
            orderLineService.deleteAll(orderLines);
        }
        orderRepository.delete(existingOrder);
    }
    public List<Order> getOrdersByUserId(Integer userId) {
        return orderRepository.findByMemberId(userId);
    }
}
