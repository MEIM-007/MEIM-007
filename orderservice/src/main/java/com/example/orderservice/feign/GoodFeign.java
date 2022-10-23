package com.example.orderservice.feign;

import com.example.orderservice.db.entity.GoodEntity;
import com.example.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "good-service")
public interface GoodFeign {

    @PostMapping("/good/update")
    R updategood(@RequestBody GoodEntity goodEntity);

    @PostMapping("/good/selectone")
    R selectOne(@RequestBody GoodEntity goodEntity);
}
