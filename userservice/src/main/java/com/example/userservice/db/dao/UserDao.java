package com.example.userservice.db.dao;

import java.util.Map;

public interface UserDao {

    public long selectUser(Map param);

    public int insertuser(Map param);

}
