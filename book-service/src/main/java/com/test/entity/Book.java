package com.test.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("db_book")
public class Book {

    @TableId(value = "bid", type = IdType.AUTO)
    public Integer id;

    public String title;

    public String detail;
}
