package com.codekul.LibraryManagement.user.controller;

import com.codekul.LibraryManagement.user.dto.UserRequestDto;
import com.codekul.LibraryManagement.user.entity.Users;
import com.codekul.LibraryManagement.user.service.UsersService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;



    @PostMapping("save")
    public String saveUsers(@RequestBody UserRequestDto userRequestDto) {

        return usersService.save(userRequestDto);
    }

    @GetMapping("list")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }


}
