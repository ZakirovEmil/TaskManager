package com.zakirovemil.taskmanager.service;

import com.zakirovemil.taskmanager.entity.UserEntity;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserException;
import com.zakirovemil.taskmanager.exception_handling.exception.UserAlreadyExistException;
import com.zakirovemil.taskmanager.model.UserModel;

import java.util.List;

public interface UserService {
    UserEntity getUserByLogin(String login) throws NoSuchUserException;

    List<UserModel> getAllUsers();

    void registerUser(UserEntity userEntity) throws UserAlreadyExistException;

    void updateUser(UserEntity userEntity, String login) throws NoSuchUserException;

    void deleteUser(String login) throws NoSuchUserException;

}
