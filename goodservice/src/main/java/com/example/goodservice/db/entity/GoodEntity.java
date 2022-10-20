package com.example.goodservice.db.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("good")
public class GoodEntity {

    @TableId(value = "id", type = IdType.AUTO)
    public Long id;

    public String name;

    public String type;

    public Integer sum;

    public Integer price;

    public String address;

    public String detail;

    public String other;

    public String img;
}
