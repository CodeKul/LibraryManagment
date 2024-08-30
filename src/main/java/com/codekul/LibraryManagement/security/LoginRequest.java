package com.codekul.LibraryManagement.security;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {

    private String userName;

    private String password;
}
