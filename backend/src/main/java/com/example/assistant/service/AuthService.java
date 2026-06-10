package com.example.assistant.service;

import com.example.assistant.dto.LogResponse;
import com.example.assistant.dto.LoginRequest;
import com.example.assistant.dto.RegisterRequest;
import com.example.assistant.entity.User;
import com.example.assistant.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepo userRep;

    public AuthService(UserRepo userRep){
        this.userRep=userRep;
    }

    public LogResponse register(RegisterRequest request){
        User user=new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
//        user.getCreatedAt(request.getCreateAt());
        User saved= userRep.save(user);
        return new LogResponse(saved.getEmail(),saved.getName(),saved.getCreatedAt());
    }

    public String login(LoginRequest request){
        User user =
                userRep.findByEmail(request.getEmail());
        if(user == null){
            return "Invalid Email";
        }
        if(!user.getPassword().equals(request.getPassword())){
            return "Invalid Password";
        }
        return "Login Successful";
    }
}
