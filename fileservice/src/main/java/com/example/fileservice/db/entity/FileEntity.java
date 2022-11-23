package com.example.fileservice.db.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("file")
@Data
public class FileEntity {

    public Long id;

    public String type;

    public Double size;

    public String url;

    public Data createTime;
}
