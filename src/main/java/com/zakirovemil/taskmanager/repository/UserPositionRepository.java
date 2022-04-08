package com.zakirovemil.taskmanager.repository;

import com.zakirovemil.taskmanager.entity.PositionEntity;
import com.zakirovemil.taskmanager.entity.UserEntity;
import com.zakirovemil.taskmanager.entity.UserPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPositionRepository extends JpaRepository<UserPositionEntity, Long> {
    UserPositionEntity findByPositionAndUser(PositionEntity position, UserEntity user);

    UserPositionEntity findByUser(UserEntity user);
}
