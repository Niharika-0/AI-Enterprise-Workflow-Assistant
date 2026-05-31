package com.example.assistant.controller;


import com.example.assistant.dto.CreateTaskRequest;
import com.example.assistant.dto.TaskResponse;
import com.example.assistant.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/settask")
    public TaskResponse createTask(
            @RequestBody CreateTaskRequest request) {
        return  taskService.createTas(request.getTaskName());
    }

    @DeleteMapping("delete/task/{taskName}")
    public String deletTask(@PathVariable String taskName)
    {
        if(taskService.deletetask(taskName))return "Task Deleted Successfully.";
        else return "May be task Name not present.";
    }
}
