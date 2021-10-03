package com.example.lab1.services;

import com.example.lab1.dto.TaskDto;
import com.example.lab1.model.Task;

import java.util.List;

public interface TaskService {
    Task findById(Long id);

    Task findByName(String name);

    List<Task> findAllByUserId(Long id);

    List<Task> findAllByUserIdAndName(Long id, String name);

    void deleteTaskById(Long id);

    void addTask(TaskDto task) throws Exception;

    void updateTask(Long id, TaskDto task);
}
