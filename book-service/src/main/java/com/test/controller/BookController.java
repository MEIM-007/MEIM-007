package com.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.entity.Book;
import com.test.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    BookService bookService;

    @PostMapping("/update")
    public boolean updateDate(@RequestBody Book book){
        return bookService.saveOrUpdate(book);
    }

    @GetMapping("/delete")
    public boolean deleteDate(@RequestParam Integer id){
        return bookService.removeById(id);
    }

    @PostMapping ("/delete/batch")
    public boolean deleteBatchDate(@RequestBody List<Integer> ids){
        return bookService.removeBatchByIds(ids);
    }

    @GetMapping("/page")
    public IPage findPage(@RequestParam Integer pageNum,
                          @RequestParam Integer pageSize
                          ) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        return bookService.page(new Page<>(pageNum, pageSize),queryWrapper);
    }

    @GetMapping("/find/{id}")
    public Book findOne(@PathVariable("id") Integer id){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("bid", id);
        return bookService.getOne(queryWrapper);
    }
}