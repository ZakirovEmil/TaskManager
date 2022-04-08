package com.zakirovemil.taskmanager.service;

import com.zakirovemil.taskmanager.entity.TaskEntity;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchTaskException;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskService {

    TaskEntity getTaskById(long id) throws NoSuchTaskException;

    void deleteTask(long id) throws NoSuchTaskException;

    void updateTask(TaskEntity taskEntity) throws NoSuchTaskException;

    void createTaskWithUserByLogin(TaskEntity taskEntity, String login);

    List<TaskEntity> getAllUserTasks(String login) throws NoSuchUserException;

    List<TaskEntity> getAllTasks();
}
