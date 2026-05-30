package com.example.assistant.dto;

public class TaskResponse {

    private String taskName;

    public  TaskResponse(String taskName){
        this.taskName=taskName;
    }
    public String getTaskName() {
        return taskName;
    }


}
