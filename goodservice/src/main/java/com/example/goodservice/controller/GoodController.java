package com.example.goodservice.controller;


import cn.hutool.core.bean.BeanUtil;
import com.example.goodservice.db.entity.GoodEntity;
import com.example.goodservice.service.GoodService;
import com.example.util.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/good")
public class GoodController {

    @Resource
    public GoodService goodService;

    @PostMapping("/insert")
    public R insertgood(@RequestBody GoodEntity goodEntity){
        Map map = BeanUtil.beanToMap(goodEntity);
        if(goodService.insertgood(map)){
            return R.ok().put("msg","注册成功");
        }else return R.error(444,"注册失败");
    }

    @PostMapping("/update")
    public R updategood(@RequestBody GoodEntity goodEntity){
        Map map = BeanUtil.beanToMap(goodEntity);
        if(goodService.updategood(map)){
            return R.ok().put("msg","修改成功");
        }else return R.error(444,"修改失败");
    }

    @PostMapping("/delete")
    public R deletegood(@RequestBody GoodEntity goodEntity){
        Map param = BeanUtil.beanToMap(goodEntity);
        if(goodService.deletegood(param.get("id").toString())){
            return R.ok().put("msg","删除成功");
        }else return R.error(444,"删除失败");
    }
}
