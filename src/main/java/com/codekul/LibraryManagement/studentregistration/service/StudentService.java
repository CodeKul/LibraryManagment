package com.codekul.LibraryManagement.studentregistration.service;

import com.codekul.LibraryManagement.studentregistration.entity.StudentRegistration;
import org.springframework.stereotype.Service;


public interface StudentService  {

    String saveStudent(StudentRegistration studentRegistration);
}
