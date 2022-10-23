package com.example.orderservice.service.Impl;


import com.example.orderservice.db.dao.OrderDao;
import com.example.orderservice.db.entity.OrderEntity;
import com.example.orderservice.feign.GoodFeign;
import com.example.orderservice.service.OrderService;
import com.example.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    public GoodFeign goodFeign;

    @Resource
    public OrderDao orderDao;

    @Value("${server.port}")
    private Integer workerId;

    @Override
    @Transactional
    public boolean createOrder(Map param) {
        SnowflakeIdWorker snowflake = new SnowflakeIdWorker(workerId%2, 1);
        long id = snowflake.nextId();
        param.put("id",id);
        return false;
    }
}
