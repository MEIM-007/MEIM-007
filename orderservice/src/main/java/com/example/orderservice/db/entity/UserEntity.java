package com.example.orderservice.db.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserEntity {

    @TableId(value = "id", type = IdType.AUTO)
    public Long id;

    public String name;

    public String email;

    public String account;

    public String password;

    public String phone;

    public String address;

    public String avatar;
}
