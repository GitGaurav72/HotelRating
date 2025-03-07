package com.novaedge.micro.userservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.novaedge.micro.userservice.entity.TbNovaMcroRating;
import com.novaedge.micro.userservice.entity.TbNovaMcroUser;
import com.novaedge.micro.userservice.service.TbNovaMcroUserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class TbNovaMcroUserController {

    @Autowired
    private TbNovaMcroUserService userService;

    // Create or update a user
    @PostMapping("/register")
    public ResponseEntity<TbNovaMcroUser> createOrUpdateUser(@RequestBody TbNovaMcroUser user) {
        TbNovaMcroUser savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<TbNovaMcroUser> getUserById(@PathVariable("userId") String userId) {
        TbNovaMcroUser user = userService.getUserById(userId);
        return  ResponseEntity.ok(user);
    }

    // Get all users
    @GetMapping("/all_user")
    public ResponseEntity<List<TbNovaMcroUser>> getAllUsers() {
        List<TbNovaMcroUser> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Delete user by ID
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
    
    
    // Add new rating by userId and hotelId
    @PostMapping("/add_rating/{userId}/{hotelId}")
    public ResponseEntity<TbNovaMcroRating> addRating(@PathVariable("userId") String userId, @PathVariable("hotelId") String hotelId, @RequestBody TbNovaMcroRating tbNovaMcroRating ){
    	ResponseEntity<TbNovaMcroRating> response  = userService.addRating(userId, hotelId, tbNovaMcroRating);
         return response;
    }
}
