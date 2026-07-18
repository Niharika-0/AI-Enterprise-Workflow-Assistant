package com.example.assistant.service;

import com.example.assistant.dto.LogResponse;
import com.example.assistant.dto.LoginRequest;
import com.example.assistant.dto.RegisterRequest;
import com.example.assistant.entity.User;
import com.example.assistant.repository.UserRepo;
import com.example.assistant.security.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.Token;
import org.jspecify.annotations.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Slf4j
@Service
public class AuthService {
    private final UserRepo userRep;
    private final BCryptPasswordEncoder passwrdEncode;
    private final JwtService jwtservice;
    public AuthService(UserRepo userRep, BCryptPasswordEncoder passwrdEncode, JwtService jwtservice){
        this.userRep=userRep;
        this.passwrdEncode=passwrdEncode;
        this.jwtservice = jwtservice;
    }

    public LogResponse register(RegisterRequest request){
        if(userRep.findByEmail(request.getEmail()) != null){
            throw new RuntimeException("Email already exists");
        }
        User user=new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(passwrdEncode.encode(request.getPassword()));
//        user.getCreatedAt(request.getCreateAt());
        User saved= userRep.save(user);
        return new LogResponse(saved.getEmail(),saved.getName(),saved.getCreatedAt());
    }

    public String login( LoginRequest request){
        log.info("finding email from db");

        User user =  userRep.findByEmail(request.getEmail()).orElseThrow(()->  new RuntimeException("User not found"));
//        log.info("Email retrieved successfully");
        if(!passwrdEncode.matches(request.getPassword(),user.getPassword())){
            log.info("Invalid Password or Username");
            throw new RuntimeException("Invalid Password");
        }
        String token = jwtservice.generateToken(request.getEmail());
        return token;
    }
}
