package com.example.userapp.controller;

import com.example.userapp.exception.ResourceNotFoundException;
import com.example.userapp.model.User;
import com.example.userapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/ws")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/get-users")
    public List<User> getAllNotes() {
        return userRepository.findAll();
    }

    @PostMapping("/post-user")
    public User createNote(@Valid @RequestBody User user) {

        return userRepository.save(user);
    }

    @GetMapping("/get-user/{id}")
    public User getNoteById(@PathVariable(value = "id") Long noteId) {

        return userRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", noteId));
    }

    @PutMapping("/update-user/{id}")
    public User updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", noteId));

        user.setTitle(userDetails.getTitle());
        user.setContent(userDetails.getContent());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        User user = userRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", noteId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
