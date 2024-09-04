package com.codekul.LibraryManagement.studentregistration.controller;

import com.codekul.LibraryManagement.studentregistration.entity.StudentRegistration;
import com.codekul.LibraryManagement.studentregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/staff/registration")
public class StudentRegistrationController {

    @Autowired
    private StudentService studentService;

    @PostMapping("save")
    public String saveREg(@RequestBody StudentRegistration studentRegistration){
        return studentService.saveStudent(studentRegistration);
    }


}
