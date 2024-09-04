package com.codekul.LibraryManagement.booksborrowed.repository;

import com.codekul.LibraryManagement.booksborrowed.entity.BooksBorrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BooksBorrowedRepo extends JpaRepository<BooksBorrowed, Long> {

    @Query(value = "select * from fn_update_book_is_availble_flag(?1)", nativeQuery = true)
    void updateBookIsAvailableFlag(Long bookId);

    @Query(value = "select * from fn_check_book_is_availble_flag(?1)", nativeQuery = true)
    Boolean checkBookIsAvailableFlag(Long bookId);

    @Query(value = "select * from fn_return_book(?1)", nativeQuery = true)
    void returnBook(Long bookBorrowedId);
}
