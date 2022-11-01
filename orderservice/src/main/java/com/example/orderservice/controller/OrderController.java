package com.example.orderservice.controller;


import cn.hutool.core.bean.BeanUtil;
import com.example.orderservice.db.entity.GoodEntity;
import com.example.orderservice.db.entity.OrderEntity;
import com.example.orderservice.service.OrderService;
import com.example.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    public OrderService orderService;

    @PostMapping("/create")
    public R createOrder(@RequestBody OrderEntity orderEntity) {
        Map param = BeanUtil.beanToMap(orderEntity);
        if(orderService.createOrder(param)){
            return R.ok().put("msg","创建订单成功");
        }else {
            return R.error().put("msg","创建订单失败");
        }
    }

}
