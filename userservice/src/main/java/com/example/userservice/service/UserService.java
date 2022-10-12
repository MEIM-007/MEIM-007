package com.example.userservice.service;

import com.example.userservice.db.entity.UserEntity;
import com.example.util.R;

import java.util.Map;

public interface UserService {

    public String login(UserEntity userEntity);

    public int register(Map param);
}
