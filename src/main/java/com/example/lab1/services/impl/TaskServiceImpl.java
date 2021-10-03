package com.example.lab1.services.impl;

import com.example.lab1.dto.TaskDto;
import com.example.lab1.model.Task;
import com.example.lab1.services.TaskService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskServiceImpl implements TaskService {

    @Override
    public Task findById(Long id) {
        return null;
    }

    @Override
    public Task findByName(String name) {
        return null;
    }

    @Override
    public List<Task> findAllByUserId(Long id) {
        return null;
    }

    @Override
    public List<Task> findAllByUserIdAndName(Long id, String name) {
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {

    }

    @Override
    public void addTask(TaskDto task) throws Exception {

    }

    @Override
    public void updateTask(Long id, TaskDto task) {

    }
}
