package com.zakirovemil.taskmanager.service;

import com.zakirovemil.taskmanager.entity.PositionEntity;
import com.zakirovemil.taskmanager.entity.UserEntity;
import com.zakirovemil.taskmanager.entity.UserPositionEntity;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchPositionException;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserException;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserPositionException;
import com.zakirovemil.taskmanager.exception_handling.exception.UserPositionAlreadyExistException;
import com.zakirovemil.taskmanager.repository.PositionRepository;
import com.zakirovemil.taskmanager.repository.UserPositionRepository;
import com.zakirovemil.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersPositionServiceImpl implements UserPositionService {

    private final UserPositionRepository userPositionRepository;
    //    private final UserRepository userRepository;
//    private final PositionRepository positionRepository;
    private final UserService userService;
    private final PositionService positionService;

    @Autowired
    public UsersPositionServiceImpl(UserPositionRepository userPositionRepository,
//                                    UserRepository userRepository,
//                                    PositionRepository positionRepository,
                                    UserService userService, PositionService positionService) {
        this.userPositionRepository = userPositionRepository;
//        this.userRepository = userRepository;
//        this.positionRepository = positionRepository;
        this.userService = userService;
        this.positionService = positionService;
    }


    @Override
    public UserPositionEntity getUserPositionByLogin(String login) throws NoSuchUserException, NoSuchUserPositionException {
        UserPositionEntity userPositionEntity = userPositionRepository.findByUser(userService.getUserByLogin(login));
        if (userPositionEntity == null) {
            throw new NoSuchUserPositionException("No such user position with login" + login);
        }
        return userPositionEntity;
    }

    @Override
    public void assignPositionToUser(String login, String positionName)
            throws NoSuchUserException, NoSuchPositionException, UserPositionAlreadyExistException {
//        UserEntity userEntity = userRepository.findUserEntityByLogin(login);
//        PositionEntity positionEntity = positionRepository.findByPositionName(positionName);
//        if (userEntity == null) {
//            throw new NoSuchUserException("No such user with login" + login);
//        }
//        if (positionEntity == null) {
//            throw new NoSuchPositionException("No such position" + positionName);
//        }
        UserEntity userEntity = userService.getUserByLogin(login);
        PositionEntity positionEntity = positionService.getPositionByName(positionName);
        if (userPositionRepository.findByPositionAndUser(positionEntity, userEntity) != null) {
            throw new UserPositionAlreadyExistException("User position already exist");
        }
        UserPositionEntity userPositionEntity = new UserPositionEntity(userEntity, positionEntity);
        userPositionRepository.save(userPositionEntity);
    }

    @Override
    public void deleteUserPosition(String login) {

    }

    @Override
    public void changePosition(String login, String positionName)
            throws NoSuchUserException, NoSuchPositionException, NoSuchUserPositionException {
        PositionEntity positionEntity = positionService.getPositionByName(positionName);
        UserPositionEntity userPosition = getUserPositionByLogin(login);

        userPosition.setPosition(positionEntity);

        userPositionRepository.save(userPosition);
    }

    @Override
    public List<UserPositionEntity> getAllUsersPositions() {
        return userPositionRepository.findAll();
    }
}
