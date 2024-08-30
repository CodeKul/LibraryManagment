package com.codekul.LibraryManagement.user.dto;

import com.codekul.LibraryManagement.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDto extends BaseEntity {

    private String userName;

    private String password;

    private String role;

}
