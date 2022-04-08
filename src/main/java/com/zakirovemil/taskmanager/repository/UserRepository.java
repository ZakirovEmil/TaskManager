package com.zakirovemil.taskmanager.repository;

import com.zakirovemil.taskmanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntityByLogin(String login);

}
