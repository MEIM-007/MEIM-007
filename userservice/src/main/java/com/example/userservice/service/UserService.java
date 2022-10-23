package com.example.userservice.service;

import com.example.userservice.db.entity.UserEntity;
import java.util.Map;

public interface UserService {

    Map login(UserEntity userEntity);

    Boolean register(Map param);

    Boolean update(Map param);

    Boolean delete(String id);

    Map selectOne(String id);

}
