package com.example.userservice.service;

import com.example.userservice.db.entity.UserEntity;
import com.example.util.PageUtils;
import com.example.util.R;

import java.util.ArrayList;
import java.util.Map;

public interface UserService {

    Map login(UserEntity userEntity);

    Boolean register(Map param);

    Boolean update(Map param);

    Boolean delete(String id);

}
