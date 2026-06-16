package com.example.assistant.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LogResponse {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String createdAt;

    public LogResponse(String name,String email,String createdAt) {
        this.name = name;
        this.email=email;
        this.createdAt=createdAt;
    }


}