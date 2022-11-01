package com.example.orderservice.service.Impl;


import cn.hutool.core.bean.BeanUtil;
import com.example.orderservice.db.dao.OrderDao;
import com.example.orderservice.db.entity.GoodEntity;
import com.example.orderservice.feign.GoodFeign;
import com.example.orderservice.service.OrderService;
import com.example.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    public GoodFeign goodFeign;

    @Resource
    public OrderDao orderDao;

    @Value("${server.port}")
    private Integer workerId;

    @Override
    @Transactional
    public boolean createOrder(Map param) {
        if(param == null) {
            return false;
        }else {
            GoodEntity goodEntity = new GoodEntity();
            goodEntity.setId((Long) param.get("GoodId"));
            Map goodMap = BeanUtil.beanToMap(goodFeign.selectOne(goodEntity).get("data"));
            if((Integer)goodMap.get("sum")>0){
                SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(workerId%2,1);
                Long id = snowflakeIdWorker.nextId();
                Date date=new Date();
                SimpleDateFormat dateFormat_min=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                param.put("id", id);
                param.put("createTime", dateFormat_min.format(date));
                if(orderDao.insertorder(param)){
                    return true;
                }else {
                    return false;
                }
            }else
                return false;
        }
    }
}
