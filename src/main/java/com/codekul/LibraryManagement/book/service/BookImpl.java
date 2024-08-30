package com.codekul.LibraryManagement.book.service;

import com.codekul.LibraryManagement.book.entity.Books;
import com.codekul.LibraryManagement.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public String saveBook(Books books) {
        var book = new Books();
        book.setAuthor(books.getAuthor());
        book.setName(books.getName());
        book.setDescription(books.getDescription());
        book.setIaAvailable(true);
        book.setIsbn(books.getIsbn());
        bookRepository.save(book);
        return "book saved";
    }
}
