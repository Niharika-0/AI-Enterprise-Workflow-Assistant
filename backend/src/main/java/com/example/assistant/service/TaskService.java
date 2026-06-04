package com.example.assistant.service;

import com.example.assistant.dto.TaskResponse;
import com.example.assistant.entity.Task;
import com.example.assistant.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }
    public List<Task> gettask(){

        return taskRepo.findAll();

    }


    public Task createTas(String taskName){

        Task task = new Task();

        task.setTaskName(taskName);

        return (Task) taskRepo.save(task);

    }


    public boolean deletetask(String taskName){

        List<Task> tasks = taskRepo.findAll();

        for(Task task : tasks){

            if(task.getTaskName()
                    .equalsIgnoreCase(taskName)){

                taskRepo.delete(task);

                return true;
            }
        }

        return false;
    }

    public Task update(Long id,String TaskName){
        Task t= taskRepo.findById(id).orElseThrow();
//            taskRepo.findAll().stream().filter(v->v.getId().equals(id));
           t.setTaskName(TaskName);
           taskRepo.save(t);
           return t;
    }
}
