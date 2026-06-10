package com.example.assistant.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String name;
    private String email;
    private String createdAt;
    private String password;
}
