package com.example.userapp.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Response class for User
 */
@Data
public class UserResponse implements Serializable{

    private Long id;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;
}
