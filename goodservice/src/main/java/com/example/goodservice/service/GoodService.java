package com.example.goodservice.service;

import java.util.Map;

public interface GoodService {

    Boolean insertgood(Map param);

    Boolean updategood(Map param);

    Boolean deletegood(String id);

    Map selectOne(String id);
}
