package com.zakirovemil.taskmanager.service;

import com.zakirovemil.taskmanager.entity.TaskDetailEntity;
import com.zakirovemil.taskmanager.repository.TaskDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskDetailServiceImpl implements TaskDetailService {

    private final TaskDetailRepository taskDetailRepository;

    @Autowired
    public TaskDetailServiceImpl(TaskDetailRepository taskDetailRepository) {
        this.taskDetailRepository = taskDetailRepository;
    }

    @Override
    public List<TaskDetailEntity> getAllTaskDetail() {
        return taskDetailRepository.findAll();
    }
}
