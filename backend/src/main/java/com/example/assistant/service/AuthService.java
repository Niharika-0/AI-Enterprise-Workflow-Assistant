package com.example.assistant.service;

import com.example.assistant.dto.LogResponse;
import com.example.assistant.dto.LoginRequest;
import com.example.assistant.dto.RegisterRequest;
import com.example.assistant.entity.User;
import com.example.assistant.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Slf4j
@Service
public class AuthService {
    private final UserRepo userRep;
    private final BCryptPasswordEncoder passwrdEncode;

    public AuthService(UserRepo userRep, BCryptPasswordEncoder passwrdEncode){
        this.userRep=userRep;
        this.passwrdEncode=passwrdEncode;
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

    public String login(LoginRequest request){
        log.info("finding email from db");
        Optional<User> user = Optional.of(new User());
        try {
             user =
                     Optional.ofNullable(userRep.findByEmail(request.getEmail()));
        } catch (Exception e) {
            log.info("Email Exception");
            throw new RuntimeException(e);
        }

        log.info("Email retrieved successfully");
        if(user.isEmpty()){
            log.info("Invalid Email");
            return "Invalid Email";
        }
        if(!passwrdEncode.matches(user.get().getPassword(),request.getPassword()) ||  !user.get().getName().equals(request.getName())){
            log.info("Invalid Password or Username");
            return "Invalid Password or UserName";
        }
        log.info("Successful");
        return "Login Successful";
    }
}
