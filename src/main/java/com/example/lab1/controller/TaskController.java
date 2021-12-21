package com.example.lab1.controller;

import com.example.lab1.dto.TaskDto;
import com.example.lab1.model.Task;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user/task")
public class TaskController {

    @GetMapping("/all")
    public List<Task> all(){
        ArrayList<Task> arr = new ArrayList<Task>();
        TaskDto task1 = new TaskDto();
        task1.setName("Berth");
        task1.setDescription("Song 1");

        arr.add(TaskDto.CreateTask(task1));


        TaskDto task2 = new TaskDto();
        task2.setName("Signer");
        task2.setDescription("Song 2");

        arr.add(TaskDto.CreateTask(task2));
        return arr;
    }
}
