package com.codekul.LibraryManagement.booksborrowed.controller;

import com.codekul.LibraryManagement.booksborrowed.entity.BooksBorrowed;
import com.codekul.LibraryManagement.booksborrowed.service.BookBorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff/bookBorrowed")
public class BookBorrowedController {

    @Autowired
    private BookBorrowedService bookBorrowedService;


    @PostMapping("save")
    public String saveBookBorrowed(@RequestBody BooksBorrowed booksBorrowed) {
        return bookBorrowedService.saveBookBorrowed(booksBorrowed);
    }

    @PostMapping("return")
    public String saveBookBorrowed(@PathVariable("id") Long borrowedId) {
        return bookBorrowedService.returnBook(borrowedId);
    }




}
