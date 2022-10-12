package com.example.userservice.db.entity;


import lombok.Data;

@Data
public class UserEntity {

    public long id;

    public String name;

    public String email;

    public String account;

    public String password;

    public String phone;

    public String address;

    public String avatar;
}
