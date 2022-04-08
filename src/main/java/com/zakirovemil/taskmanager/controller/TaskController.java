package com.zakirovemil.taskmanager.controller;

import com.zakirovemil.taskmanager.entity.TaskEntity;

import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchTaskException;
import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserException;
import com.zakirovemil.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/{id}")
    public TaskEntity getTaskById(@PathVariable long id) throws NoSuchTaskException {
        return taskService.getTaskById(id);
    }

    @GetMapping
    public List<TaskEntity> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/user/{login}")
    public List<TaskEntity> getAllUserTasks(@PathVariable String login) throws NoSuchUserException {
        return taskService.getAllUserTasks(login);
    }

    @PostMapping("/{login}")
    public TaskEntity createTaskWithUserByLogin(@RequestBody TaskEntity taskEntity, @PathVariable String login) {
        taskService.createTaskWithUserByLogin(taskEntity, login);
        return taskEntity;
    }

    @PutMapping
    public TaskEntity updateTask(@RequestBody TaskEntity taskEntity) throws NoSuchTaskException {
        taskService.updateTask(taskEntity);
        return taskEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable long id) throws NoSuchTaskException {
        taskService.deleteTask(id);
        return ResponseEntity.ok().body("Task with id = " + id + " deleted");
    }
}
