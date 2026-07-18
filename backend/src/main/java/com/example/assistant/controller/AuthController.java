package com.example.assistant.controller;

import com.example.assistant.config.securityConfig;
import com.example.assistant.dto.LogResponse;
import com.example.assistant.dto.LoginRequest;
import com.example.assistant.dto.RegisterRequest;
import com.example.assistant.service.AuthService;
//import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

   private final  AuthService auth;

   public AuthController(AuthService auth){
       this.auth=auth;
   }

    @PostMapping("/register")
    public LogResponse register(@Valid  @RequestBody RegisterRequest req){
       return auth.register(req);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest req){
        return auth.login(req);
    }
}
