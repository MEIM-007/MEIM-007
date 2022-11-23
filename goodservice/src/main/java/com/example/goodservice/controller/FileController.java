package com.example.goodservice.controller;


import com.example.goodservice.db.entity.GoodEntity;
import com.example.goodservice.service.FileService;
import com.example.goodservice.service.GoodService;
import com.example.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    public FileService fileService;

    @Resource
    public GoodService goodService;

    @RequestMapping("/upload")
    public R uploadFile(@RequestParam("imgFile") MultipartFile file) throws IOException {
        String path = fileService.uploadFile(file);
        Map map = new HashMap();
        map.put("img", path);
        if(goodService.insertgood(map)) {
            return R.ok().put("msg", path);
        }else return R.error(444,"上传失败");
    }

    @RequestMapping("/download")
    public R downloadFile(){
        fileService.downloadFile();
        return R.ok().put("msg", "正在下载");
    }

    @RequestMapping("/delete")
    public R deleteFile(){
        fileService.deleteFile();
        return R.ok().put("msg", "删除成功");
    }
}
