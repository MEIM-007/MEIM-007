package com.example.userservice.db.dao;

import org.apache.ibatis.annotations.MapKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserDao {

    public long selectUser(Map param);

    public Map getOther(Map param);

    public int insertuser(Map param);

}
