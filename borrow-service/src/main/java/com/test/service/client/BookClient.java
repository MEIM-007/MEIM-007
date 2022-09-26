package com.test.service.client;

import com.test.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("bookservice")
public interface BookClient {

    @GetMapping("/book/find/{id}")
    Book findOne(@PathVariable("id") Integer id);

}