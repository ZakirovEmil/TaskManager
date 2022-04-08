package com.zakirovemil.taskmanager.controller;

import com.zakirovemil.taskmanager.entity.TaskDetailEntity;
import com.zakirovemil.taskmanager.service.TaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks_details")
public class TaskDetailController {

    private final TaskDetailService taskDetailService;

    @Autowired
    public TaskDetailController(TaskDetailService taskDetailService) {
        this.taskDetailService = taskDetailService;
    }

    @GetMapping
    public List<TaskDetailEntity> getAllTasksDetails() {
        return taskDetailService.getAllTaskDetail();
    }

}
