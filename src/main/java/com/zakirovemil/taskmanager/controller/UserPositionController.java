package com.zakirovemil.taskmanager.controller;

import com.zakirovemil.taskmanager.entity.UserPositionEntity;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchPositionException;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserException;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserPositionException;
import com.zakirovemil.taskmanager.exception_handling.exception.UserPositionAlreadyExistException;
import com.zakirovemil.taskmanager.service.UserPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users_positions")
public class UserPositionController {

    private UserPositionService userPositionService;

    @Autowired
    public UserPositionController(UserPositionService userPositionService) {
        this.userPositionService = userPositionService;
    }

    @GetMapping
    public List<UserPositionEntity> getAllUsersPositions() {
        return userPositionService.getAllUsersPositions();
    }

    @PostMapping("/{positionName}/{login}")
    public String assignPositionToUser(@PathVariable String positionName, @PathVariable String login)
            throws NoSuchUserException, UserPositionAlreadyExistException, NoSuchPositionException {
        userPositionService.assignPositionToUser(login, positionName);
        return "Assign " + positionName + " to " + login;
    }

    @PutMapping("/{positionName}/{login}")
    public String changePosition(@PathVariable String positionName, @PathVariable String login)
            throws NoSuchUserException, NoSuchPositionException, NoSuchUserPositionException {
        userPositionService.changePosition(login, positionName);
        return "Change position to " + positionName + " for " + login;
    }

    @DeleteMapping("/{login}")
    public String deleteUserPosition(@PathVariable String login) {
        userPositionService.deleteUserPosition(login);
        return "User position" + login + "delete";
    }
}
