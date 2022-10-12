package com.example.userservice.service.Impl;


import cn.hutool.core.lang.Snowflake;
import com.example.exception.GlobalException;
import com.example.userservice.db.dao.UserDao;
import com.example.userservice.db.entity.UserEntity;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Resource
    private UserDao userDao;

    @Override
    @Transactional
    public String login(UserEntity userEntity) {
        HashMap map = new HashMap();
        map.put("account", userEntity.getAccount());
        map.put("password", userEntity.getPassword());
        if(userDao.selectUser(map) == 0){
            throw new GlobalException("用户不存在");
        }else {
            return "登录成功";
        }
    }

    @Override
    @Transactional
    public int register(Map param) {
        if(userDao.selectUser(param) != 0){
            throw new GlobalException("用户已存在");
        }
        else {
            Snowflake snowflake = new Snowflake(1, 1);
            HashMap map = new HashMap();
            map.put("id", snowflake.nextId());
            return userDao.insertuser(map);
        }
    }
}
