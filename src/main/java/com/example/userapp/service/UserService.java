package com.example.userapp.service;

import com.example.userapp.dto.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Layer for User Specific Functions
 */
@Service
public interface UserService {

    /**
     * Get All Users
     * @return List of Users
     */
    List<UserResponse> getAllUsers();
}
