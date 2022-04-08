package com.zakirovemil.taskmanager.service;

import com.zakirovemil.taskmanager.entity.UserPositionEntity;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchPositionException;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserException;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserPositionException;
import com.zakirovemil.taskmanager.exception_handling.exception.UserPositionAlreadyExistException;

import java.util.List;

public interface UserPositionService {
    UserPositionEntity getUserPositionByLogin(String login) throws NoSuchUserException, NoSuchUserPositionException;

    void assignPositionToUser(String login, String positionName) throws NoSuchUserException, NoSuchPositionException, UserPositionAlreadyExistException;

    void deleteUserPosition(String login);

    void changePosition(String login, String positionName) throws NoSuchUserException, NoSuchPositionException, NoSuchUserPositionException;

    List<UserPositionEntity> getAllUsersPositions();
}
