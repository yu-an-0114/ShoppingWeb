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
    public void saveAll(List<OrderLine> orderLines) {
        orderLineRepository.saveAll(orderLines);
    }
    public List<OrderLine> findByOrderId(Integer orderId) {
        return orderLineRepository.findByOrderId(orderId);
    }
    public void save(OrderLine orderLine) {
        orderLineRepository.save(orderLine);
    }

    public void deleteAll(List<OrderLine> orderLines) {
        orderLineRepository.deleteAll(orderLines);
    }
}
