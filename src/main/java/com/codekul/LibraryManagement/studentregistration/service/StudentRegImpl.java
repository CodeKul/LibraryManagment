package com.codekul.LibraryManagement.studentregistration.service;

import com.codekul.LibraryManagement.studentregistration.entity.StudentRegistration;
import com.codekul.LibraryManagement.studentregistration.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentRegImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String saveStudent(StudentRegistration registration) {
       var student = new StudentRegistration();
       student.setAddress(registration.getAddress());
       student.setName(registration.getName());
       student.setEmail(registration.getEmail());
       student.setGender(registration.getGender());
       student.setMobileNumber(registration.getMobileNumber());
       studentRepo.save(registration);
       return "student reg saved";
    }
}
