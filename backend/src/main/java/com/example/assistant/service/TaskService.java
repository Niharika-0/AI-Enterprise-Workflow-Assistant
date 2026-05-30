package com.example.assistant.service;

import com.example.assistant.dto.TaskResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    public List<TaskResponse> gettask(){
        List<TaskResponse> tasks=new ArrayList<>();
        tasks.add(new TaskResponse("Learn Spring Boot"));
        tasks.add(new TaskResponse("Practice DSA"));
        tasks.add(new TaskResponse("Study System Design"));
        return tasks;

    }
}
