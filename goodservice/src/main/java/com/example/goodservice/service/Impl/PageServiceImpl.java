package com.example.goodservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goodservice.Util.PageMapper;
import com.example.goodservice.db.entity.GoodEntity;
import com.example.goodservice.service.PageService;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, GoodEntity> implements PageService {
}
