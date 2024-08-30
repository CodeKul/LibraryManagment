package com.codekul.LibraryManagement.security;

import com.codekul.LibraryManagement.user.entity.Users;
import com.codekul.LibraryManagement.user.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository userRepository; // Assume you have a UserRepository

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        // Convert roles to authorities
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        for (String role : user.getRole()) {
        System.out.println("CustomUserDetailsService===>"+user.getRole());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
//        }

        return User.builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
