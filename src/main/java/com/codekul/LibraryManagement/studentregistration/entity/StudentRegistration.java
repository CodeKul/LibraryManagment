package com.codekul.LibraryManagement.studentregistration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class StudentRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name can not be null")
    private String name;

    private String address;

    @NotNull(message = "mobile number can not be null")
    private String mobileNumber;

    private String gender;

    private String email;

}
