package com.codekul.LibraryManagement.studentregistration.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentRequestDto {

    @NotNull(message = "name can not be null")
    private String name;

    private String address;

    @NotNull(message = "mobile number can not be null")
    private String mobileNumber;

    private String gender;

    private String email;

}
