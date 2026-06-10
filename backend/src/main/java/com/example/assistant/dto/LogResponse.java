package com.example.assistant.dto;

public class LogResponse {
    private String name;
    private String email;
    private String createdAt;

    public LogResponse(String name,String email,String createdAt) {
        this.name = name;
        this.email=email;
        this.createdAt=createdAt;
    }


}