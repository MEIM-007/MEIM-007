package com.example.userservice.db.dao;

import java.util.Map;

public interface UserDao {

    long selectUser(Map param);

    Map getOther(Map param);

    int insertuser(Map param);
    int updateuser(Map param);

    int deleteuser(String id);

}
