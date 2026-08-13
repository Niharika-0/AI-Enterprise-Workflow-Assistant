package com.example.assistant.controller;


import com.example.assistant.dto.CreateTaskRequest;
import com.example.assistant.dto.TaskResponse;
import com.example.assistant.entity.Task;
import com.example.assistant.repository.TaskRepo;
import com.example.assistant.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TaskController {

    private TaskService taskService;
    private TaskRepo taskRepo;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping("/task")
    public List<Task> task(){
       return  taskService.gettask();
    }

    @PostMapping("/task/create")
    public Task createTask(CreateTaskRequest request) {

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());

        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());

        return taskRepo.save(task);
    }

    @DeleteMapping("delete/task/{taskName}")
    public String deletTask(@PathVariable String taskName)
    {
        if(taskService.deletetask(taskName))return "Task Deleted Successfully.";
        else return "May be task Name not present.";
    }

    @PutMapping("/update/task/{id}")
    public Task updatetask(@PathVariable Long id, @RequestBody CreateTaskRequest req){
       return  taskService.update(id,req.getTaskName());
    }
}
