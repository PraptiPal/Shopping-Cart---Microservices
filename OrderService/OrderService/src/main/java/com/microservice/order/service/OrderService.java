package com.microservice.order.service;

import com.microservice.order.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> viewAllOrders();

    Order getOrderById(Long orderId);

    String cancelOrder(Long orderId);
}

