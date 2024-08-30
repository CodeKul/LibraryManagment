package com.codekul.LibraryManagement.book.controller;

import com.codekul.LibraryManagement.book.entity.Books;
import com.codekul.LibraryManagement.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/saveBook")
    public String saveBook(@RequestBody Books books){
        return bookService.saveBook(books);
    }
}
