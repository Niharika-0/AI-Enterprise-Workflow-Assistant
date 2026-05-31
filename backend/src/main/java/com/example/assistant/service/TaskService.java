package com.example.assistant.service;

import com.example.assistant.dto.TaskResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    List<TaskResponse> tasks=new ArrayList<>();
    public List<TaskResponse> gettask(){

        tasks.add(new TaskResponse("Learn Spring Boot"));
        tasks.add(new TaskResponse("Practice DSA"));
        tasks.add(new TaskResponse("Study System Design"));
        return tasks;

    }

    public TaskResponse createTas(String taskName){
        TaskResponse task=new TaskResponse(taskName);
        tasks.add(task);
        return task;
    }

    public boolean deletetask(String taskName){
        return tasks.removeIf(task->task.getTaskName().equalsIgnoreCase(taskName));
    }
}
