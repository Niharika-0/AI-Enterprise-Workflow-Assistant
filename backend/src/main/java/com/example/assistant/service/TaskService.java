package com.example.assistant.service;

import com.example.assistant.dto.CreateTaskRequest;
import com.example.assistant.dto.TaskResponse;
import com.example.assistant.entity.Task;
import com.example.assistant.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }
    public List<Task> getTasks(){

        return taskRepo.findAll();

    }

    public Task getTaskById(Long id) {

        return taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    public Task createTas(String taskName){

        Task task = new Task();

        task.setTitle(taskName);

        return (Task) taskRepo.save(task);

    }


    public boolean deletetask(String taskName){

        List<Task> tasks = taskRepo.findAll();

        for(Task task : tasks){

            if(task.getTitle()
                    .equalsIgnoreCase(taskName)){

                taskRepo.delete(task);

                return true;
            }
        }

        return false;
    }
    public Task update(Long id, CreateTaskRequest request) {

        Task task = taskRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found with id: " + id));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());

        task.setUpdatedAt(LocalDateTime.now());

        return taskRepo.save(task);
    }
}
