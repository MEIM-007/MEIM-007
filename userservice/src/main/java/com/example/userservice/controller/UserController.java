package com.example.userservice.controller;


import cn.hutool.core.bean.BeanUtil;
import com.example.userservice.Util.JwtUtil;
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
        Map map = userService.login(userEntity);
        if(map.get("code").equals("200")) {
            String token = JwtUtil.createJWT(map.get("id").toString(),null);
            return R.ok().put("token",token);
        }else {
            return R.error(map.get("code").toString(),map.get("msg").toString());
        }
    }

    @PostMapping("/register")
    public R register(@RequestBody UserEntity userEntity){
        Map param = BeanUtil.beanToMap(userEntity);
        if (userService.register(param)){
            return R.error(444,"注册失败");}
        else {
            return R.ok().put("msg","注册成功");
        }
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
