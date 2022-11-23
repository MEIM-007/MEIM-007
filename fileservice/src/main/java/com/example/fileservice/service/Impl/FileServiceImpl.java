package com.example.fileservice.service.Impl;


import com.example.fileservice.db.dao.FileDao;
import com.example.fileservice.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class FileServiceImpl  implements FileService {

    @Resource
    public FileDao fileDao;

    @Override
    public boolean upload(Map param) {
        return false;
    }

    @Override
    public boolean download(Map param) {
        return false;
    }

    @Override
    public boolean delete(Map param) {
        return false;
    }

    @Override
    public boolean query(Map param) {
        return false;
    }
}
