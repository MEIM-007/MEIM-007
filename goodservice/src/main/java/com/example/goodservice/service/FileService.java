package com.example.goodservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    public String uploadFile(MultipartFile file) throws IOException;

    public void uploadFiles(MultipartFile[] files) throws IOException;

    public String downloadFile();

    public String deleteFile();
}
