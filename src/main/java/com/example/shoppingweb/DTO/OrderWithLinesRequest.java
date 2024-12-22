package com.example.shoppingweb.dto;

import com.example.shoppingweb.model.Order;
import com.example.shoppingweb.model.OrderLine;

import java.util.List;

public class OrderWithLinesRequest {

    private Order order;
    private List<OrderLine> orderLines;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}