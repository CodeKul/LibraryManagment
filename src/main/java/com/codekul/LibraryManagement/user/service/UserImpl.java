package com.codekul.LibraryManagement.user.service;

import com.codekul.LibraryManagement.user.dto.UserRequestDto;
import com.codekul.LibraryManagement.user.entity.Users;
import com.codekul.LibraryManagement.user.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String save(UserRequestDto userRequestDto) {
        var users = new Users();
        String encodedPassword = passwordEncoder.encode(userRequestDto.getPassword());
        users.setUserName(userRequestDto.getUserName());
        users.setRole(userRequestDto.getRole());
        users.setPassword(encodedPassword);

        var createdBy = new Users();
        createdBy.setId(1L);

        users.setCreatedBy(createdBy);
        users.setLastModifiedBy(createdBy);

        usersRepository.save(users);
        return "users saved successfully";
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
