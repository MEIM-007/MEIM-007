package com.example.userservice.controller;


import cn.hutool.core.bean.BeanUtil;
import com.example.userservice.db.entity.UserEntity;
import com.example.userservice.service.UserService;
import com.example.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    public UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody UserEntity userEntity){
        return R.ok().put("data", userService.login(userEntity));
    }

    @PostMapping("/register")
    public R register(@RequestBody UserEntity userEntity){
        Map param = BeanUtil.beanToMap(userEntity);
        return R.ok().put("data", userService.register(param));
    }
}
