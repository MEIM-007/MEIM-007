package com.example.userservice.service;

import com.example.userservice.db.entity.UserEntity;
import com.example.util.R;

import java.util.ArrayList;
import java.util.Map;

public interface UserService {

    public Map login(UserEntity userEntity);

    public Boolean register(Map param);

}
