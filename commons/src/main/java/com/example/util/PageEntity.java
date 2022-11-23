package com.example.util;


import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Data
public class PageEntity {

    public Integer pageNum;

    public Integer pageSize;

    public String account;

    public String yytname;

    public String phone;

    public String address;

    public String type;

    public BigDecimal price;
}
