package com.example.userservice.Util;


import lombok.Data;

@Data
public class PageEntity {

    public Integer pageNum;

    public Integer pageSize;

    public String account;

    public String phone;

    public String address;
}
