package com.codekul.LibraryManagement.user.repository;

import com.codekul.LibraryManagement.user.dto.UserInfoResponse;
import com.codekul.LibraryManagement.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByUserName(String username);
    Users findByUserNameAndPassword(String username,String password);

    @Query(value = "select * from fn_getUserInfo(?1,?2)",nativeQuery = true)
    UserInfoResponse getUserInfo(String userName, String password);
}
