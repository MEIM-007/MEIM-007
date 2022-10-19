package com.example.userservice.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.userservice.Util.PageMapper;
import com.example.userservice.db.entity.UserEntity;
import com.example.userservice.service.PageService;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, UserEntity> implements PageService {
}
