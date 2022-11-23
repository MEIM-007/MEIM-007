package com.example.goodservice.service.Impl;

import com.example.goodservice.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        File dir = new File("uploadFile");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        file.transferTo(new File(dir.getAbsolutePath() + File.separator));
        return dir.getAbsolutePath() + File.separator;
    }

    @Override
    public void uploadFiles(MultipartFile[] files) throws IOException {
        File dir = new File("uploadFile");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        for (MultipartFile file : files) {
            file.transferTo(new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename()));
        }
    }

    @Override
    public String downloadFile() {
        return null;
    }

    @Override
    public String deleteFile() {
        return null;
    }
}
