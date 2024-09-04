package com.codekul.LibraryManagement.booksborrowed.service;

import com.codekul.LibraryManagement.booksborrowed.entity.BooksBorrowed;
import com.codekul.LibraryManagement.booksborrowed.repository.BooksBorrowedRepo;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookBorrowedImpl implements BookBorrowedService {

    @Autowired
    private BooksBorrowedRepo booksBorrowedRepo;

    @Override
    public String saveBookBorrowed(BooksBorrowed booksBorrowed) {
        Long id = booksBorrowed.getBooks().getId();

        if (booksBorrowedRepo.checkBookIsAvailableFlag(id)) {
            var bookBorrowed = new BooksBorrowed();
            bookBorrowed.setBooks(bookBorrowed.getBooks());
            bookBorrowed.setStudentRegistration(bookBorrowed.getStudentRegistration());
            booksBorrowedRepo.save(booksBorrowed);
            booksBorrowedRepo.updateBookIsAvailableFlag(id);
            return "saved";
        } else {
            return "book is already issued";
        }
    }

    @Override
    public String returnBook(Long borrowedId) {
        booksBorrowedRepo.returnBook(borrowedId);
        return "books return successfully";
    }
}
