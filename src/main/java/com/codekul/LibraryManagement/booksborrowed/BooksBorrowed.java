package com.codekul.LibraryManagement.booksborrowed;

import com.codekul.LibraryManagement.BaseEntity;
import com.codekul.LibraryManagement.book.entity.Books;
import com.codekul.LibraryManagement.studentregistration.StudentRegistration;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class BooksBorrowed extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentRegistration studentRegistration;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books books;

    private LocalDate borrowedDate;

    private LocalDate returnDate;

}
