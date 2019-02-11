package com.example.userapp.service.impl;


import com.example.userapp.dto.response.UserResponse;
import com.example.userapp.model.User;
import com.example.userapp.repository.UserRepository;
import com.example.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUsers() {

        List<UserResponse> userResponses = new ArrayList<>();

        List<User> users = userRepository.findAll();
        for(User user : users){
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.getId());
            userResponse.setContent(user.getContent());
            userResponse.setTitle(user.getTitle());
            userResponse.setCreatedAt(user.getCreatedAt());
            userResponse.setUpdatedAt(user.getUpdatedAt());
            userResponses.add(userResponse);
        }
        return userResponses;
    }
}
