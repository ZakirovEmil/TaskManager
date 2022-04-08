package com.zakirovemil.taskmanager.controller;

import com.zakirovemil.taskmanager.entity.UserEntity;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserException;
import com.zakirovemil.taskmanager.exception_handling.exception.UserAlreadyExistException;
import com.zakirovemil.taskmanager.model.UserModel;
import com.zakirovemil.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{login}")
    public UserEntity getUserByLogin(@PathVariable String login) throws NoSuchUserException {
        return userService.getUserByLogin(login);
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserEntity registerUser(@RequestBody UserEntity userEntity) throws UserAlreadyExistException {
        userService.registerUser(userEntity);
        return userEntity;
    }

    @PutMapping("/{login}")
    public UserEntity updateUser(@RequestBody UserEntity userEntity, @PathVariable String login) throws NoSuchUserException {
        userService.updateUser(userEntity, login);
        return userEntity;
    }

    @DeleteMapping("/{login}")
    public ResponseEntity<String> deleteUser(@PathVariable String login) throws NoSuchUserException {
        userService.deleteUser(login);
        return ResponseEntity.ok().body("User with login " + login + " deleted");
    }
}
