package com.microservice.order.service.impl;

import com.microservice.order.entity.Order;
import com.microservice.order.repository.OrderRepository;
import com.microservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> viewAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }

    @Override
    public String cancelOrder(Long orderId) {
        orderRepository.deleteById(orderId);
        return "Order Cancelled";
    }
}
