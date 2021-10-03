package com.example.lab1.dto;

import com.example.lab1.model.Task;
import lombok.Data;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
public class TaskDto {
    @Size(max = 40)
    private String name;

    @Size(max = 4000)
    private String description;

    private String dateOfCreation;
    private String dateOfDeadline;
    private Long userId;

    public static Task CreateTask(TaskDto taskDto){
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setDateOfCreation(taskDto.getDateOfCreation());

        return task;
    }
}
