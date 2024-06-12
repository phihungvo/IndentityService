package com.luv2code.IdentityService.controller;

import com.luv2code.IdentityService.dto.request.UserCreationRequest;
import com.luv2code.IdentityService.dto.request.UserUpdateRequest;
import com.luv2code.IdentityService.entity.User;
import com.luv2code.IdentityService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody @Valid UserCreationRequest request){
        return userService.createUser(request);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
       return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }










}
