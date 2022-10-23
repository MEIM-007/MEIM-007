package com.example.orderservice.feign;

import com.example.orderservice.db.entity.UserEntity;
import com.example.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "user-service")
public interface UserFeign {

    @PostMapping("/user/selectone")
    R selectOne(@RequestBody UserEntity userEntity);

}
