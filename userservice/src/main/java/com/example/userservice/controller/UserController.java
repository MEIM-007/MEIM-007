package com.example.userservice.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.userservice.Util.JwtUtil;
import com.example.util.PageEntity;
import com.example.userservice.db.entity.UserEntity;
import com.example.userservice.service.PageService;
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

    @Resource
    public PageService pageService;

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
        if (!userService.register(param)){
            return R.error(444,"注册失败");}
        else {
            return R.ok().put("msg","注册成功");
        }
    }

    @PostMapping("/update")
    public R update(@RequestBody UserEntity userEntity){
        Map param = BeanUtil.beanToMap(userEntity);
        if (!userService.update(param)){
            return R.error(444,"修改失败");}
        else {
            return R.ok().put("msg","修改成功");
        }
    }

    @PostMapping("/delete")
    public R delete(@RequestBody UserEntity userEntity){
        Map param = BeanUtil.beanToMap(userEntity);
        if (!userService.delete(param.get("id").toString())){
            return R.error(444,"删除失败");}
        else {
            return R.ok().put("msg","删除成功");
        }
    }

    @PostMapping("/selectone")
    public R selectOne(@RequestBody UserEntity userEntity){
        Map param = BeanUtil.beanToMap(userEntity);
        Map map = userService.selectOne(param.get("id").toString());
        if (map == null){
            return R.error(444,"查询失败");}
        else {
            return R.ok().put("data",map);
        }
    }

    @GetMapping("/page")
    public R findPage(@RequestBody PageEntity page){
        QueryWrapper<UserEntity> queryWrapper=new QueryWrapper<>();
        if(page.getAccount()!=null){
            queryWrapper.like("account",page.getAccount());
        }
        if(page.getPhone()!=null){
            queryWrapper.like("phone",page.getPhone());
        }
        if(page.getAddress()!=null){
            queryWrapper.like("address",page.getAddress());
        }
        return R.ok().put("data",pageService.page(new Page<>(page.getPageNum(), page.getPageSize()),queryWrapper));
    }
}
