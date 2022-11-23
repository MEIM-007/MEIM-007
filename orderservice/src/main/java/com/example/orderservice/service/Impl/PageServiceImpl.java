package com.example.orderservice.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.orderservice.Util.PageMapper;
import com.example.orderservice.db.entity.OrderEntity;
import com.example.orderservice.service.PageService;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, OrderEntity> implements PageService {
}
