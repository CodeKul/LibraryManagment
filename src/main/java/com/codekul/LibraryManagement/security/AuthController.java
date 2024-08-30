package com.codekul.LibraryManagement.security;

import com.codekul.LibraryManagement.user.dto.UserInfoResponse;
import com.codekul.LibraryManagement.user.entity.Users;
import com.codekul.LibraryManagement.user.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUserName(),
                            loginRequest.getPassword()
                    )
            );

//            Users users = usersRepository.findByUserNa/meAndPassword(loginRequest.getUserName(),loginRequest.getPassword());

            UserInfoResponse userInfoResponse=  usersRepository.getUserInfo(loginRequest.getUserName(),loginRequest.getPassword());
            Map<String, Object> map = new HashMap<>();
            map.put("username",userInfoResponse.getUserName());
            map.put("role",userInfoResponse.getRole());
            // Generate JWT token
            String jwtToken = jwtUtil.generateToken(map);

            // Return the JWT token in the response
            return ResponseEntity.ok(new JwtResponse(jwtToken));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
