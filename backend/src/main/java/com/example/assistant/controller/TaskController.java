package com.example.assistant.controller;


import com.example.assistant.dto.TaskResponse;
import com.example.assistant.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping("/task")
    public List<TaskResponse> task(){
       return  taskService.gettask();
    }
}
