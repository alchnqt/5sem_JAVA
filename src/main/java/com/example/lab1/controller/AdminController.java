package com.example.lab1.controller;

import com.example.lab1.logging.Loggable;
import com.example.lab1.model.Task;
import com.example.lab1.model.User;
import com.example.lab1.repository.TaskRepository;
import com.example.lab1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/admin")
public class AdminController {
    private final TaskRepository repository;

    @Autowired
    public AdminController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("usage")
    @Loggable
    public List<Task> usage(){
        return repository.findAll();
    }
    @Loggable
    @PostMapping("add-category")
    public void addCategory(){

    }
    @Loggable
    @PostMapping("add-company")
    public void addCompany(){

    }
    @Loggable
    @PostMapping("add-item")
    public void addItem(){

    }
}
