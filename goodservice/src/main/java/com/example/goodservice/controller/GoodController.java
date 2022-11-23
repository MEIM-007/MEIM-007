package com.example.goodservice.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.goodservice.db.entity.GoodEntity;
import com.example.goodservice.service.GoodService;
import com.example.goodservice.service.PageService;
import com.example.util.PageEntity;
import com.example.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/good")
public class GoodController {

    @Resource
    public GoodService goodService;

    @Resource
    public PageService pageService;

    @PostMapping("/insert")
    public R insertgood(@RequestBody GoodEntity goodEntity){
        Map map = BeanUtil.beanToMap(goodEntity);
        if(goodService.insertgood(map)){
            return R.ok().put("msg","入库成功");
        }else return R.error(444,"入库失败");
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

    @PostMapping("/selectone")
    public R selectOne(@RequestBody GoodEntity goodEntity){
        Map param = BeanUtil.beanToMap(goodEntity);
        if(goodService.selectOne(param.get("id").toString()) != null){
            return R.ok().put("msg","查询成功").put("data",goodService.selectOne(param.get("id").toString()));
        }else return R.error(444,"查询失败");
    }

    @GetMapping("/page")
    public R findPage(@RequestBody PageEntity page){
        QueryWrapper<GoodEntity> queryWrapper=new QueryWrapper<>();
        if(page.getType()!=null){
            queryWrapper.like("type",page.getType());
        }
        if(page.getPrice()!=null){
            queryWrapper.like("price",page.getPrice());
        }
        return R.ok().put("data",pageService.page(new Page<>(page.getPageNum(), page.getPageSize()),queryWrapper));
    }
}
