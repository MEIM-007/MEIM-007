package com.example.orderservice.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.orderservice.db.entity.GoodEntity;
import com.example.orderservice.db.entity.OrderEntity;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.PageService;
import com.example.util.PageEntity;
import com.example.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    public OrderService orderService;

    @Resource
    public PageService pageService;

    @PostMapping("/create")
    public R createOrder(@RequestBody OrderEntity orderEntity) {
        Map param = BeanUtil.beanToMap(orderEntity);
        if(orderService.createOrder(param)){
            return R.ok().put("msg","创建订单成功");
        }else {
            return R.error().put("msg","创建订单失败");
        }
    }

    @GetMapping("/page")
    public R findPage(@RequestBody PageEntity page){
        QueryWrapper<OrderEntity> queryWrapper=new QueryWrapper<>();
        return R.ok().put("data",pageService.page(new Page<>(page.getPageNum(), page.getPageSize()),queryWrapper));
    }

}
