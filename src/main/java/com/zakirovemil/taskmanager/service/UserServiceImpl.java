package com.zakirovemil.taskmanager.service;

import com.zakirovemil.taskmanager.entity.UserEntity;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserException;
import com.zakirovemil.taskmanager.exception_handling.exception.UserAlreadyExistException;
import com.zakirovemil.taskmanager.model.UserModel;
import com.zakirovemil.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUserByLogin(String login) throws NoSuchUserException {
        UserEntity userEntityByLogin = userRepository.findUserEntityByLogin(login);
        if (userEntityByLogin != null) {
//            return new UserModel(userRepository.findUserEntityByLogin(login));
            return userRepository.findUserEntityByLogin(login);
        } else {
            throw new NoSuchUserException("No Such User with login " + login);
        }
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(UserModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public void registerUser(UserEntity userEntity) throws UserAlreadyExistException {
        UserEntity userEntityByLogin = userRepository.findUserEntityByLogin(userEntity.getLogin());
        if (userEntityByLogin == null) {
            userRepository.save(userEntity);
        } else {
            throw new UserAlreadyExistException("User with login " + userEntityByLogin.getLogin() + " already exist.");
        }

    }

    @Override
    public void updateUser(UserEntity userEntity, String login) throws NoSuchUserException {
        UserEntity userEntityByLogin = getUserByLogin(login);
        userEntity.setId(userEntityByLogin.getId());
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(String login) throws NoSuchUserException {
//        UserEntity userEntityByLogin = userRepository.findUserEntityByLogin(login);
//        if(userEntityByLogin != null) {
//            userRepository.delete(userEntityByLogin);
//        } else {
//            throw new NoSuchUserException("No Such User with login " + login);
//        }
        UserEntity userEntityByLogin = getUserByLogin(login);
        userRepository.delete(userEntityByLogin);
    }

}
