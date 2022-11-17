package com.example.springbootjpa.repository;

import com.example.springbootjpa.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User,Long> {
    Optional<User> findByUsename(String username);
}
