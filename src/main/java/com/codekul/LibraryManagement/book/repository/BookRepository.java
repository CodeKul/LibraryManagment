package com.codekul.LibraryManagement.book.repository;

import com.codekul.LibraryManagement.book.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Books,Long> {
}
