package com.zakirovemil.taskmanager.service;

import com.zakirovemil.taskmanager.entity.TaskEntity;
import com.zakirovemil.taskmanager.entity.UserEntity;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchTaskException;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserException;
import com.zakirovemil.taskmanager.repository.TaskRepository;
import com.zakirovemil.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TaskEntity getTaskById(long id) throws NoSuchTaskException {
        Optional<TaskEntity> taskEntityOptional = taskRepository.findById(id);
        if (taskEntityOptional.isEmpty()) {
            throw new NoSuchTaskException("No such task " + id);
        }
        return taskEntityOptional.get();
    }

    @Override
    public void createTaskWithUserByLogin(TaskEntity taskEntity, String login) {
        UserEntity userEntity = userRepository.findUserEntityByLogin(login);
        taskEntity.setUser(userEntity);
        taskRepository.save(taskEntity);
    }

    @Override
    public void updateTask(TaskEntity taskEntity) throws NoSuchTaskException {
        taskRepository.save(getTaskById(taskEntity.getId()));
    }

    @Override
    public void deleteTask(long id) throws NoSuchTaskException {
        TaskEntity taskById = getTaskById(id);
        taskRepository.deleteById(taskById.getId());
    }

    @Override
    public List<TaskEntity> getAllUserTasks(String login) throws NoSuchUserException {
        UserEntity userEntity = userRepository.findUserEntityByLogin(login);
        if (userEntity == null) {
            throw new NoSuchUserException("No Such User with login " + login);
        }
        return taskRepository.getAllByUser(userEntity);
    }

    @Override
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }
}
