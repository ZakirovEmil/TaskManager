package com.zakirovemil.taskmanager.repository;

import com.zakirovemil.taskmanager.entity.TaskEntity;
import com.zakirovemil.taskmanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> getAllByUser(UserEntity user);
}
