package com.example.fileservice.controller;


import com.example.util.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/file")
@RestController
public class FileController {

    //上传文件
    @PostMapping("/upload")
    public R upload(){
        return R.ok();
    }

    //下载文件
    @PostMapping("/download")
    public String download(){
        return "download";
    }

    //删除文件
    @PostMapping("/delete")
    public String delete(){
        return "delete";
    }

    //查询文件
    @PostMapping("/query")
    public String query(){
        return "query";
    }

}
