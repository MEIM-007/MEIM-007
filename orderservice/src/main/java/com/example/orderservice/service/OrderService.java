package com.example.orderservice.service;

import com.example.orderservice.db.entity.OrderEntity;

import java.util.Map;

public interface OrderService {

    boolean createOrder(Map param);
}
