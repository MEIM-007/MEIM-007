package com.example.orderservice.db.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.sql.Time;

@Data
public class OrderEntity  {

    public Long id;

    public Long UserId;

    public Integer num;

    public Long GoodId;

    public String type;

    public BigDecimal price;

    public Time create;
}
