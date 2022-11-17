package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.UserRequest;
import com.example.springbootjpa.domain.dto.UserResponse;
import com.example.springbootjpa.domain.entity.User;
import com.example.springbootjpa.repository.UserRespository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class UserServiceTest {
    private UserRespository userRepository = Mockito.mock(UserRespository.class);
    private UserService userService;

    @BeforeEach
    void setup() {
        userService = new UserService(userRepository);
    }
    @Test
    @DisplayName("회원 등록 성공 메세지가 나오는지")
    void addTest() {
        Mockito.when(userRepository.save(any()))
                .thenReturn(new User(1l,"sanghee","1111"));
        UserResponse userResponse = userService.addUser(new UserRequest("sanghee","1111"));
        assertEquals("회원 등록 성공", userResponse.getMessage());
        assertEquals("sanghee", userResponse.getUsername());
    }
}