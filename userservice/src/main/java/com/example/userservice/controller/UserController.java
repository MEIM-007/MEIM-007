package com.example.userservice.controller;


import cn.dev33.satoken.stp.StpUtil;
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
        if(userService.login(userEntity).equals("账号或密码不能为空")){
            return R.error(441,"账号或密码不能为空");
        } else if (userService.login(userEntity).equals("账号或密码错误")) {
            return R.error(442,"账号或密码错误");
        } else {
            return R.ok().put("token", userService.login(userEntity));
        }
    }

    @PostMapping("/register")
    public R register(@RequestBody UserEntity userEntity){
        Map param = BeanUtil.beanToMap(userEntity);
        if (userService.register(param) == 0L){
            return R.error(444,"注册失败");}
        else {
            long id = userService.register(param);
            StpUtil.login(id);
            String token = StpUtil.getTokenInfo().getTokenValue();
            return R.ok().put("注册成功", token);
        }
    }
}
