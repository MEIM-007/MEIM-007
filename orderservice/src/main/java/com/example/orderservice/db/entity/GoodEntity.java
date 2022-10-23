package com.example.orderservice.db.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("good")
public class GoodEntity {

    @TableId(value = "id", type = IdType.AUTO)
    public Long id;

    public String name;

    public String type;

    public Integer sum;

    public BigDecimal price;

    public String address;

    public String detail;

    public String other;

    public String img;
}
