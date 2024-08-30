package com.codekul.LibraryManagement.user.service;

import com.codekul.LibraryManagement.user.dto.UserRequestDto;
import com.codekul.LibraryManagement.user.entity.Users;

import java.util.List;

public interface UsersService {

    String save(UserRequestDto userRequestDto);

    List<Users> getAllUsers();
}
