package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.UserRequest;
import com.example.springbootjpa.domain.dto.UserResponse;
import com.example.springbootjpa.domain.entity.User;
import com.example.springbootjpa.repository.UserRespository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public UserResponse addUser(UserRequest dto){
        User user = dto.toEntity();

        Optional<User> selectedUser = userRespository.findByUsename(dto.getUsername());
        if(selectedUser.isEmpty()){
            User savedUser = userRespository.save(user);
            return new UserResponse(savedUser.getId(), savedUser.getUsername(), "회원 등록 성공");
        }else{
            return new UserResponse(null, dto.getUsername(),"이 user은 이미 존재합니다.");
        }

    }
    public UserResponse getUser(Long id){
        Optional<User> optUser = userRespository.findById(id);

        if(optUser.isEmpty()){
            return new UserResponse(id, "","해당 id의 사용자가 없습니다.");
        }else{
            User user = optUser.get();
            return new UserResponse(user.getId(),user.getUsername(),"");
        }
    }
}
