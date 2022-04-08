package com.zakirovemil.taskmanager.repository;

import com.zakirovemil.taskmanager.entity.TaskDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDetailRepository extends JpaRepository<TaskDetailEntity, Long> {
}
