package com.example.goodservice.db.dao;

import java.util.Map;

public interface GoodDao {

    Integer insertgood(Map param);

    Integer updategood(Map param);

    Integer deletegood(String id);

}
