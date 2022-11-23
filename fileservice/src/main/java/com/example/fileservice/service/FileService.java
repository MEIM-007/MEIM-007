package com.example.fileservice.service;

import java.util.Map;

public interface FileService {

    boolean upload(Map param);

    boolean download(Map param);

    boolean delete(Map param);

    boolean query(Map param);
}
