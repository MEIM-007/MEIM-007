package com.example.goodservice.service.Impl;


import cn.hutool.core.lang.Snowflake;
import com.example.goodservice.db.dao.GoodDao;
import com.example.goodservice.service.GoodService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class GoodServiceImpl implements GoodService {

    @Resource
    private GoodDao goodDao;

    @Value("${server.port}")
    private Integer workerId;

    @Override
    public Boolean insertgood(Map param) {
        Snowflake snowflake = new Snowflake(workerId%2, 1);
        long id = snowflake.nextId();
        param.put("id",id);
        if(goodDao.insertgood(param) == 1){
            return true;
        }else return false;
    }

    @Override
    public Boolean updategood(Map param) {
        if(goodDao.updategood(param) == 1){
            return true;
        }else return false;
    }

    @Override
    public Boolean deletegood(String id) {
        if(goodDao.deletegood(id) == 1){
            return true;
        }else return false;
    }
}
