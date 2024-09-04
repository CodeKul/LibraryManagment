package com.codekul.LibraryManagement.booksborrowed.service;

import com.codekul.LibraryManagement.booksborrowed.entity.BooksBorrowed;

public interface BookBorrowedService {

    String saveBookBorrowed(BooksBorrowed booksBorrowed);

    String returnBook(Long borrowedId);
}
