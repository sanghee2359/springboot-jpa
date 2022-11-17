package com.example.springbootjpa.repository;

import com.example.springbootjpa.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User,Long> {
}
