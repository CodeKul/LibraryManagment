package com.codekul.LibraryManagement.studentregistration.repository;

import com.codekul.LibraryManagement.studentregistration.entity.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentRegistration,Long> {
}
