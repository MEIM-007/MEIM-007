package com.example.userservice.service;

import com.example.userservice.db.entity.UserEntity;
import com.example.util.R;

import java.util.ArrayList;
import java.util.Map;

public interface UserService {

    public String login(UserEntity userEntity);

    public long register(Map param);

}
