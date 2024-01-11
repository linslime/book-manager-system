package com.evan.wj.controller;

import com.evan.wj.mapper.BookMapper;
import com.evan.wj.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LibraryController {
    @Resource
    BookMapper bookMapper;

    @ResponseBody
    @GetMapping("/api/books")
    public List<Book> list() {
        return bookMapper.findAll();
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) {
        System.out.println(book);
        book.setCid(1);
        book.setId(10000);
        bookMapper.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) {
        bookMapper.deleteById(book.getId());
    }

    @ResponseBody
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid){
        if (0 != cid) {
            return bookMapper.listByCategory(cid);
        } else {
            return list();
        }
    }
}

